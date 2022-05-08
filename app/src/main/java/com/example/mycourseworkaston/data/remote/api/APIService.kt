package com.example.mycourseworkaston.data.remote.api

import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeRemoteList
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationsRemoteList
import retrofit2.http.GET

interface APIService {

    @GET("/character")
    suspend fun getCharacter() : CharacterRemoteList

    @GET("/episode")
    suspend fun getEpisodes() : EpisodeRemoteList

    @GET("/location")
    suspend fun getLocations(): LocationsRemoteList

}