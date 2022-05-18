package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.local.converters.toDomain
import com.example.mycourseworkaston.data.local.dao.EpisodeDao
import com.example.mycourseworkaston.data.remote.api.ApiServiceEpisode
import com.example.mycourseworkaston.data.repository.mapper.EpisodeRemoteToEpisodeLocal
import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel
import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val api: ApiServiceEpisode,
    private val dao: EpisodeDao,
    private val mapperEpisode: EpisodeRemoteToEpisodeLocal
) : EpisodeRepository {

    suspend fun loadDataEpisodeList() {
        var response = api.getEpisodesList()
        for (i in response.results) {
            dao.insertEpisode(mapperEpisode.mapEpisode(i))
        }
        for (i in 2..response.info.pages) {

            response = api.getEpisodesList(i)
            for (j in response.results) {
                dao.insertEpisode(mapperEpisode.mapEpisode(j))
            }
        }
    }

    override suspend fun getEpisodeList(): List<EpisodeInfoDomainModel> {
        var dataEpisode = dao.getEpisodeList()
        return if (dataEpisode.isNotEmpty()) {
            dataEpisode.map { it.toDomain() }
        } else {
            loadDataEpisodeList()
            dataEpisode = dao.getEpisodeList()
            dataEpisode.map { it.toDomain() }
        }
    }

    override suspend fun getEpisodeItem(itemId: Int): EpisodeInfoDomainModel {
        TODO("Not yet implemented")
    }
}