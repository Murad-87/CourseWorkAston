package com.example.mycourseworkaston.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeUiModel(
    val id: Int,
    val air_date: String,
    val characters: List<String>,
    val episode: String,
    val created: String,
    val url: String,
    val name: String
): Parcelable
