package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel
import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeItemUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {

    suspend fun getEpisodeItem(episodeItem: Int): EpisodeInfoDomainModel{
        return repository.getEpisodeItem(episodeItem)
    }
}