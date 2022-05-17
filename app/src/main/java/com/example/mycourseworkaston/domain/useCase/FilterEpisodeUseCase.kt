package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.repository.EpisodeRepository
import javax.inject.Inject

class FilterEpisodeUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
}