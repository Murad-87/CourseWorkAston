package com.example.mycourseworkaston.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class LocationLocalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val dimension: String,
    val created: String
)
