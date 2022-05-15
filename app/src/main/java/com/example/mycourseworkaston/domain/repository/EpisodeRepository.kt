package com.example.mycourseworkaston.domain.repository

import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel

interface EpisodeRepository {

    suspend fun getEpisodeList(): List<EpisodeInfoDomainModel>

    suspend fun getEpisodeItem(itemId: Int): EpisodeInfoDomainModel
}