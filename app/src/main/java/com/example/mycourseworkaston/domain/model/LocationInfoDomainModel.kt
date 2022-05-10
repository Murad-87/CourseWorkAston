package com.example.mycourseworkaston.domain.model

data class LocationInfoDomainModel(
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val dimension: String
)
