package com.example.mycourseworkaston.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycourseworkaston.data.local.dao.RickAndMortyDao
import com.example.mycourseworkaston.data.local.model.CharacterLocalEntity
import com.example.mycourseworkaston.data.local.model.EpisodeLocalEntity
import com.example.mycourseworkaston.data.local.model.LocationLocalEntity

@Database(
    entities = [CharacterLocalEntity::class, EpisodeLocalEntity::class, LocationLocalEntity::class],
    version = 1
)
abstract class RickAndMortyDatabase : RoomDatabase() {

    abstract fun getRickAndMortyDao(): RickAndMortyDao
}