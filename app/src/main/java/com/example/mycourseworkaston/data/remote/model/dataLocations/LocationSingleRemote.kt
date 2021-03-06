package com.example.mycourseworkaston.data.remote.model.dataLocations

data class LocationSingleRemote(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)