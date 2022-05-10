package com.example.mycourseworkaston.presentation.model

data class LocationUiModel(
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val dimension: String
)
