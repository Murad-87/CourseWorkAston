package com.example.mycourseworkaston.data.remote.api

import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceCharacter {

    @GET("character/")
    suspend fun getCharacterList(
        @Query("page") page: Int = 1
    ): CharacterRemoteList

    @GET("character/")
    suspend fun getCharactersListFilter(
        @Query("name") name: String = "",
        @Query("status") status: String = "",
        @Query("species") species: String = "",
        @Query("type") type: String = "",
        @Query("gender") gender: String = ""
    ): Response<CharacterRemoteList>
}