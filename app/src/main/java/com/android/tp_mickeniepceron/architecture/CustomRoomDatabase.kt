package com.android.tp_mickeniepceron.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.tp_mickeniepceron.dao.CityDao
import com.android.tp_mickeniepceron.model.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class
    ],
    version = 1,
    exportSchema = false
)

abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mCityDao() : CityDao
}