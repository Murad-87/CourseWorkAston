package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel
import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor() : EpisodeRepository {


    override suspend fun getEpisodeList(): List<EpisodeInfoDomainModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeItem(itemId: Int): EpisodeInfoDomainModel {
        TODO("Not yet implemented")
    }


}