package com.example.mycourseworkaston.domain.model

data class EpisodeInfoDomainModel(
    val id: Int,
    val air_date: String,
    val characters: List<String>,
    val episode: String,
    val name: String,
    val created: String,
    val url: String
)
