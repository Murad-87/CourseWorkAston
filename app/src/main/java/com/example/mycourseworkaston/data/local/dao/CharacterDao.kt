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
interface CharacterDao {

    @Query("SELECT * FROM character_table")
    fun flowCharacter(): Flow<List<CharacterLocalEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterLocalEntity)

}