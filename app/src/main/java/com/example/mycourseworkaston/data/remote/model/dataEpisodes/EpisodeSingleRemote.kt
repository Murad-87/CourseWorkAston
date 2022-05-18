package com.example.mycourseworkaston.data.remote.model.dataEpisodes

data class EpisodeSingleRemote(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)