package com.android.tp_mickeniepceron.chuckNorris.repository

import androidx.lifecycle.LiveData
import com.android.tp_mickeniepceron.architecture.CustomApplication
import com.android.tp_mickeniepceron.architecture.RetrofitBuilder
import com.android.tp_mickeniepceron.chuckNorris.model.ChuckNorrisRetrofit
import com.android.tp_mickeniepceron.chuckNorris.model.ChuckNorrisRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisQuoteRepository {
    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.mChuckNorrisDao()

    fun selectAllChuckNorrisQuote(): LiveData<List<ChuckNorrisRoom>> {
        return chuckNorrisDao.selectAll()
    }

    private suspend fun insertChuckNorrisQuote(chuckNorrisQuote: ChuckNorrisRoom) =
        withContext(Dispatchers.IO) {
            chuckNorrisDao.insert(chuckNorrisQuote)
        }

    suspend fun deleteAllChuckNorrisQuote() = withContext(Dispatchers.IO) {
        chuckNorrisDao.deleteAll()
    }

    suspend fun fetchData() {
        insertChuckNorrisQuote(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }
}

private fun ChuckNorrisRetrofit.toRoom(): ChuckNorrisRoom {
    return ChuckNorrisRoom(
        quote = quote,
        iconUrl = iconUrl
    )
}
