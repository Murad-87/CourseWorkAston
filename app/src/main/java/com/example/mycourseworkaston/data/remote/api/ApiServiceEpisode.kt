package com.example.mycourseworkaston.data.remote.api

import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeRemoteList
import retrofit2.http.GET

interface ApiServiceEpisode {
    @GET("/episode")
    suspend fun getEpisodes() : EpisodeRemoteList
}