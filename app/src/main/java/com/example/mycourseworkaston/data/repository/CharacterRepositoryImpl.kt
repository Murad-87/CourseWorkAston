package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.local.dao.RickAndMortyDao
import com.example.mycourseworkaston.data.remote.api.ApiServiceCharacter
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote
import com.example.mycourseworkaston.data.repository.mapper.CharacterRemoteToCharacterLocal
import com.example.mycourseworkaston.data.repository.mapper.EpisodeRemoteToEpisodeLocal
import com.example.mycourseworkaston.data.repository.mapper.LocationRemoteToLocationLocal

class CharacterRepositoryImpl(
    private val apiService: ApiServiceCharacter,
    private val dao: RickAndMortyDao,
    private val mapperCharacter: CharacterRemoteToCharacterLocal,
    private val mapperEpisode: EpisodeRemoteToEpisodeLocal,
    private val mapperLocation: LocationRemoteToLocationLocal
) {


    suspend fun insertCharacter(characterRemote: CharacterSingleRemote){
        characterRemote.let ( mapperCharacter::mapCharacter)
            .let { dao.insertCharacter(it) }
    }

}