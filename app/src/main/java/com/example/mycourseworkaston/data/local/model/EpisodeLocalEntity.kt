package com.example.mycourseworkaston.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "episode_table")
data class EpisodeLocalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val air_date: String,
    val characters: List<String>,
    val episode: String,
    val name: String,
)
