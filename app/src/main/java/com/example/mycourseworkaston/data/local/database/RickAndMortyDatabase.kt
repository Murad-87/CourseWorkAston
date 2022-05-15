package com.example.mycourseworkaston.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mycourseworkaston.data.local.dao.CharacterDao
import com.example.mycourseworkaston.data.local.dao.EpisodeDao
import com.example.mycourseworkaston.data.local.dao.LocationDao
import com.example.mycourseworkaston.data.local.model.CharacterLocalEntity
import com.example.mycourseworkaston.data.local.model.EpisodeLocalEntity
import com.example.mycourseworkaston.data.local.model.LocationLocalEntity

@Database(
    entities = [CharacterLocalEntity::class, EpisodeLocalEntity::class, LocationLocalEntity::class],
    version = 2
)
@TypeConverters(Converters::class)
abstract class RickAndMortyDatabase : RoomDatabase() {

    abstract fun getCharacterDao(): CharacterDao

    abstract fun getEpisodeDao(): EpisodeDao

    abstract fun getLocationDao(): LocationDao



    companion object {
        const val DATABASE_NAME = "rickAndMorty_database"
    }
}