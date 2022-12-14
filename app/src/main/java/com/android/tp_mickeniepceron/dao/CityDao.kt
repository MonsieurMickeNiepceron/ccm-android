package com.android.tp_mickeniepceron.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.tp_mickeniepceron.model.LocalDataSourceSample

@Dao
interface CityDao {
    @Query("SELECT * FROM city_table ORDER BY cityName ASC")
    fun selectAll(): LiveData<List<LocalDataSourceSample>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cityData: LocalDataSourceSample)

    @Query("DELETE FROM city_table")
    fun deleteAll()
}