package com.example.mycourseworkaston.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycourseworkaston.data.local.model.LocationLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Query("SELECT * FROM location_table")
    suspend fun getLocationList(): List<LocationLocalEntity>

    @Query("SELECT * FROM location_table WHERE id = :locationId LIMIT 1")
    fun flowLocationItem(locationId: Int): Flow<LocationLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: LocationLocalEntity)
}