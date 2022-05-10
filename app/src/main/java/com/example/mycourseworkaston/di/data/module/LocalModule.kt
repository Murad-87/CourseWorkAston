package com.example.mycourseworkaston.di.data.module

import android.content.Context
import androidx.room.Room
import com.example.mycourseworkaston.data.local.dao.RickAndMortyDao
import com.example.mycourseworkaston.data.local.database.RickAndMortyDatabase
import dagger.Module
import dagger.Provides

@Module
class LocalModule {

    @Provides
    fun provideRickAndMortyDatabase(context: Context): RickAndMortyDatabase {
        return Room.databaseBuilder(context, RickAndMortyDatabase::class.java, RickAndMortyDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideRickAndMortyDao(rickAndMortyDatabase: RickAndMortyDatabase): RickAndMortyDao{
        return rickAndMortyDatabase.getRickAndMortyDao()
    }
}