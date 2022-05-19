package com.example.mycourseworkaston.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table")
data class CharacterLocalEntity(
    @PrimaryKey(autoGenerate = false)
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
    val episode: List<String>,
)
