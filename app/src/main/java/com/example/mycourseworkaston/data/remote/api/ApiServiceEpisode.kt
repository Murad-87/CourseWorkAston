package com.example.mycourseworkaston.data.remote.api

import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeRemoteList
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceEpisode {

    @GET("episode/")
    suspend fun getEpisodesList(
        @Query("page") page: Int = 1
    ): EpisodeRemoteList

    @GET("episode/")
    suspend fun getEpisodesListFilter(
        @Query("name") name: String = "",
        @Query("episode") episode: String = ""
    ): Response<EpisodeRemoteList>
}