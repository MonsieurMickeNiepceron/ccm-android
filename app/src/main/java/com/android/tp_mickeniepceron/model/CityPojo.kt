package com.android.tp_mickeniepceron.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class LocalDataSourceSample(
    @ColumnInfo(name = "cityName")
    val cityName: String,

    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "image")
    val image: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
class CityPojo {
}

