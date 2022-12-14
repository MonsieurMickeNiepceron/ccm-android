package com.android.tp_mickeniepceron.viewmodel

import androidx.lifecycle.*
import com.android.tp_mickeniepceron.model.CityData
import com.android.tp_mickeniepceron.model.CityDataFooter
import com.android.tp_mickeniepceron.model.CityDataHeader
import com.android.tp_mickeniepceron.model.CityObjectForRecyclerView
import com.android.tp_mickeniepceron.repository.CityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityViewModel : ViewModel() {
    private val _cityList = MutableLiveData<List<CityObjectForRecyclerView>>()
    private val cityRepository: CityRepository by lazy { CityRepository() }

    val cityList: LiveData<List<CityObjectForRecyclerView>> = cityRepository.selectAllCity().map { list ->
        list.toMyCityObjectForRecyclerView()
    }

    init {
        _cityList.postValue(cityRepository.generateData())
    }

    private fun List<CityData>.toMyCityObjectForRecyclerView(): List<CityObjectForRecyclerView> {
        val result = mutableListOf<CityObjectForRecyclerView>()

        groupBy {
            it.cityCountry == "France"
        }.forEach { (b, cityData) ->
            result.add(CityDataHeader("Is a french city: $b"))
            result.addAll(cityData)
            result.add(CityDataFooter("Hello this is a footer"))
        }
        return result
    }

    fun insertCity(cityName: String, country: String, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            cityRepository.insertCity(
                CityData(cityName, country, url)
            )
        }
    }

    fun deleteAllCity() {
        viewModelScope.launch(Dispatchers.IO) {
            cityRepository.deleteAllCity()
        }
    }
}