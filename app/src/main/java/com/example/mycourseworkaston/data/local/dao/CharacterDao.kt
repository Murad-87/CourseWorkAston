package com.example.mycourseworkaston.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycourseworkaston.data.local.model.CharacterLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_table")
    suspend fun getCharacterList(): List<CharacterLocalEntity>

    @Query("SELECT * FROM character_table WHERE id =:characterId LIMIT 1")
    fun flowCharacterItem(characterId: Int): Flow<CharacterLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterLocalEntity)
}