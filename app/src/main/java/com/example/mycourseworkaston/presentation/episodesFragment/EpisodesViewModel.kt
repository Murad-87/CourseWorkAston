package com.example.mycourseworkaston.presentation.episodesFragment

import androidx.lifecycle.ViewModel
import com.example.mycourseworkaston.domain.EpisodeUseCase
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(private val episodeUseCase: EpisodeUseCase) :
    ViewModel() {
}