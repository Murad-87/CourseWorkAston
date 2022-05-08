package com.example.mycourseworkaston.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "episode_table")
data class EpisodeLocalEntity(
    val id: Int,
    val air_date: String,
    val characters: List<String>,
    val episode: String,
    val name: String,
) : Parcelable
