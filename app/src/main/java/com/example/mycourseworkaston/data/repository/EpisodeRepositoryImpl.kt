package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.local.dao.EpisodeDao
import com.example.mycourseworkaston.data.remote.api.ApiServiceEpisode
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote
import com.example.mycourseworkaston.data.repository.mapper.EpisodeRemoteToEpisodeLocal
import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel
import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val api: ApiServiceEpisode,
    private val dao: EpisodeDao,
    private val mapperEpisode: EpisodeRemoteToEpisodeLocal
) : EpisodeRepository {

    override fun getEpisodeList(): List<EpisodeInfoDomainModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeItem(itemId: Int): EpisodeInfoDomainModel {
        TODO("Not yet implemented")
    }

    override suspend fun insertEpisode(episodeRemote: EpisodeSingleRemote) {
        episodeRemote.let(mapperEpisode::mapEpisode)
            .let { dao.insertEpisode(it) }
    }
}