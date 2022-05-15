package com.example.mycourseworkaston.di

import com.example.mycourseworkaston.data.repository.CharacterRepositoryImpl
import com.example.mycourseworkaston.data.repository.EpisodeRepositoryImpl
import com.example.mycourseworkaston.data.repository.LocationRepositoryImpl
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import com.example.mycourseworkaston.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module

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
}