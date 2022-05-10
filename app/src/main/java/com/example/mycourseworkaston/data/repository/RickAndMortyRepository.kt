package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.local.dao.RickAndMortyDao
import com.example.mycourseworkaston.data.remote.api.APIService
import com.example.mycourseworkaston.data.remote.api.RetrofitInstance
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeRemoteList
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationsRemoteList
import com.example.mycourseworkaston.data.repository.mapper.CharacterRemoteToCharacterLocal
import com.example.mycourseworkaston.data.repository.mapper.EpisodeRemoteToEpisodeLocal
import com.example.mycourseworkaston.data.repository.mapper.LocationRemoteToLocationLocal

class RickAndMortyRepository(
    private val apiService: APIService,
    private val dao: RickAndMortyDao,
    private val mapperCharacter: CharacterRemoteToCharacterLocal,
    private val mapperEpisode: EpisodeRemoteToEpisodeLocal,
    private val mapperLocation: LocationRemoteToLocationLocal
) {

    suspend fun getCharacter(): CharacterRemoteList {
        return RetrofitInstance.api.getCharacter()
    }

    suspend fun getEpisode(): EpisodeRemoteList {
        return RetrofitInstance.api.getEpisodes()
    }

    suspend fun getLocation(): LocationsRemoteList{
        return RetrofitInstance.api.getLocations()
    }

    suspend fun insertCharacter(characterRemote: CharacterSingleRemote){
        characterRemote.let ( mapperCharacter::mapCharacter)
            .let { dao.insertCharacter(it) }

    }
}