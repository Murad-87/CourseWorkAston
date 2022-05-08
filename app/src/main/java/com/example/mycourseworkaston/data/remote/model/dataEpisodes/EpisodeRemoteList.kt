package com.example.mycourseworkaston.data.remote.model.dataEpisodes

import androidx.annotation.Keep

@Keep
data class EpisodeRemoteList(
    val info: Info,
    val results: List<EpisodeSingleRemote>
)