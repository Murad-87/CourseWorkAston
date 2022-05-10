package com.example.mycourseworkaston.domain

import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeRemoteList
import com.example.mycourseworkaston.data.repository.RickAndMortyRepository

class EpisodeUseCase(private val repository: RickAndMortyRepository) {

    suspend fun get(): EpisodeRemoteList{
        return repository.getEpisode()
    }
}