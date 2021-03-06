package com.example.mycourseworkaston.domain.model

data class CharacterInfoDomainModel(
    val id: Int,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val image: String,
    val type: String,
    val locationName: String,
    val locationUrl: String,
    val originName: String,
    val originUrl: String,
    val episode: List<String>
)
