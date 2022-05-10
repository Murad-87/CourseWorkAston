package com.example.mycourseworkaston.di.data.module

import com.example.mycourseworkaston.data.local.dao.RickAndMortyDao
import com.example.mycourseworkaston.data.remote.api.APIService
import com.example.mycourseworkaston.data.repository.RickAndMortyRepository
import com.example.mycourseworkaston.data.repository.mapper.CharacterRemoteToCharacterLocal
import com.example.mycourseworkaston.data.repository.mapper.EpisodeRemoteToEpisodeLocal
import com.example.mycourseworkaston.data.repository.mapper.LocationRemoteToLocationLocal
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideCharacterRemoteToCharacterLocal(): CharacterRemoteToCharacterLocal = CharacterRemoteToCharacterLocal()

    @Provides
    fun provideEpisodeRemoteToEpisodeLocal(): EpisodeRemoteToEpisodeLocal = EpisodeRemoteToEpisodeLocal()

    @Provides
    fun provideLocationRemoteToLocationLocal(): LocationRemoteToLocationLocal = LocationRemoteToLocationLocal()

    @Provides
    fun provideRickAndMortyRepository(
        apiService: APIService,
        dao: RickAndMortyDao,
        mapperCharacter: CharacterRemoteToCharacterLocal,
        mapperEpisode: EpisodeRemoteToEpisodeLocal,
        mapperLocation: LocationRemoteToLocationLocal
    ) : RickAndMortyRepository {
        return RickAndMortyRepository(
            apiService, dao, mapperCharacter, mapperEpisode, mapperLocation
        )
    }
}