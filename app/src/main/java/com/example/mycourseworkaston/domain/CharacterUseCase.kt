package com.example.mycourseworkaston.domain

import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList
import com.example.mycourseworkaston.data.repository.RickAndMortyRepository

class CharacterUseCase(private val repository: RickAndMortyRepository) {
    suspend fun get(): CharacterRemoteList {
        return repository.getCharacter()
    }
}