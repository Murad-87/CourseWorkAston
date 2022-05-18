package com.example.mycourseworkaston.domain.repository

import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote
import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel

interface EpisodeRepository {

    fun getEpisodeList(): List<EpisodeInfoDomainModel>

    suspend fun getEpisodeItem(itemId: Int): EpisodeInfoDomainModel

    suspend fun insertEpisode(episodeRemote: EpisodeSingleRemote)
}