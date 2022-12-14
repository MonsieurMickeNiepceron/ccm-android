package com.android.tp_mickeniepceron.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.tp_mickeniepceron.model.CityObjectForRecyclerView
import com.android.tp_mickeniepceron.repository.CityRepository

class CityViewModel : ViewModel() {
    private val _cityList = MutableLiveData<List<CityObjectForRecyclerView>>()
    val cityList: LiveData<List<CityObjectForRecyclerView>> get() = _cityList
    private val cityRepository: CityRepository by lazy { CityRepository() }

    init {
        _cityList.postValue(cityRepository.generateData())
    }
}