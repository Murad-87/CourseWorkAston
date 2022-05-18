package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel
import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeListUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {

    suspend fun getEpisodeList(): List<EpisodeInfoDomainModel> {
        return repository.getEpisodeList()
    }
}