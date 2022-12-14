package com.android.tp_mickeniepceron.model

sealed class CityObjectForRecyclerView()

data class CityDataHeader(
    val header: String
):CityObjectForRecyclerView()

data class CityDataFooter(
    val footer: String
):CityObjectForRecyclerView()

data class CityData(
    val cityName : String,
    val cityCountry : String,
    val image: String
):CityObjectForRecyclerView()