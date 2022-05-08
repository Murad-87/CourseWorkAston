package com.example.mycourseworkaston.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycourseworkaston.data.local.model.CharacterLocalEntity
import com.example.mycourseworkaston.data.local.model.EpisodeLocalEntity
import com.example.mycourseworkaston.data.local.model.LocationLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RickAndMortyDao {

    @Query("SELECT * FROM character_table")
    fun flowCharacter(): Flow<List<CharacterLocalEntity>>

    @Query("SELECT * FROM episode_table")
    fun flowEpisode(): Flow<List<EpisodeLocalEntity>>

    @Query("SELECT * FROM location_table")
    fun flowLocation(): Flow<List<LocationLocalEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterLocalEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: EpisodeLocalEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: LocationLocalEntity)
}