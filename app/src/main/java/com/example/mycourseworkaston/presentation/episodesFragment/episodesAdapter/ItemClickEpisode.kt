package com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter

import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote

interface ItemClickEpisode {

    fun onItemClick(episode: EpisodeSingleRemote)
}