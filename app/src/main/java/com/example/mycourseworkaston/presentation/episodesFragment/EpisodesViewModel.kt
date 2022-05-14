package com.example.mycourseworkaston.presentation.episodesFragment

import androidx.lifecycle.ViewModel
import com.example.mycourseworkaston.domain.useCase.EpisodeListUseCase
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(private val episodeUseCase: EpisodeListUseCase) :
    ViewModel() {
}