package com.example.mycourseworkaston.di

import android.app.Application
import androidx.room.Room
import com.example.mycourseworkaston.data.local.dao.CharacterDao
import com.example.mycourseworkaston.data.local.dao.EpisodeDao
import com.example.mycourseworkaston.data.local.dao.LocationDao
import com.example.mycourseworkaston.data.local.database.RickAndMortyDatabase
import com.example.mycourseworkaston.data.repository.CharacterRepositoryImpl
import com.example.mycourseworkaston.data.repository.EpisodeRepositoryImpl
import com.example.mycourseworkaston.data.repository.LocationRepositoryImpl
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import com.example.mycourseworkaston.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

    @Binds
    @ApplicationScope
    fun bindEpisodeRepository(impl: EpisodeRepositoryImpl): EpisodeRepository

    @Binds
    @ApplicationScope
    fun bindLocationRepository(impl: LocationRepositoryImpl): LocationRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideRickAndMortyDatabase(application: Application): RickAndMortyDatabase {
            return Room.databaseBuilder(
                application,
                RickAndMortyDatabase::class.java,
                RickAndMortyDatabase.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Provides
        @ApplicationScope
        fun provideCharacterDao(rickAndMortyDatabase: RickAndMortyDatabase): CharacterDao{
            return rickAndMortyDatabase.getCharacterDao()
        }

        @Provides
        @ApplicationScope
        fun provideEpisodeDao(rickAndMortyDatabase: RickAndMortyDatabase): EpisodeDao{
            return rickAndMortyDatabase.getEpisodeDao()
        }

        @Provides
        @ApplicationScope
        fun provideLocationDao(rickAndMortyDatabase: RickAndMortyDatabase): LocationDao{
            return rickAndMortyDatabase.getLocationDao()
        }

    }
}