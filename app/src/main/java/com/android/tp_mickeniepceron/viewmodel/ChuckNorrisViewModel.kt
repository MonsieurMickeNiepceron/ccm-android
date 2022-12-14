package com.android.tp_mickeniepceron.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.android.tp_mickeniepceron.chuckNorris.model.ChuckNorrisRoom
import com.android.tp_mickeniepceron.chuckNorris.model.ChuckNorrisUi
import com.android.tp_mickeniepceron.chuckNorris.repository.ChuckNorrisQuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChuckNorrisViewModel : ViewModel() {

    private val chuckNorrisQuoteRepository: ChuckNorrisQuoteRepository by lazy { ChuckNorrisQuoteRepository() }
    var chuckNorrisQuoteLiveData: LiveData<List<ChuckNorrisUi>> = chuckNorrisQuoteRepository.selectAllChuckNorrisQuote().map {
        it.toUi()
    }

    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            chuckNorrisQuoteRepository.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            chuckNorrisQuoteRepository.deleteAllChuckNorrisQuote()
        }
    }
}

private fun List<ChuckNorrisRoom>.toUi(): List<ChuckNorrisUi> {
    return asSequence().map {
        ChuckNorrisUi(
            quote = it.quote,
            iconUrl = it.iconUrl
        )
    }.toList()
}