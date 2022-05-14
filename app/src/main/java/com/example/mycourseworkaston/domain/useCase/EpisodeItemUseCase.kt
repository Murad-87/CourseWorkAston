package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeItemUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
}