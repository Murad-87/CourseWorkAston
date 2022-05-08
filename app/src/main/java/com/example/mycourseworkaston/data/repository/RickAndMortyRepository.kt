package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.remote.api.RetrofitInstance
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList

class RickAndMortyRepository {

    suspend fun getCharacter(): CharacterRemoteList {
        return RetrofitInstance.api.getCharacter()
    }
}