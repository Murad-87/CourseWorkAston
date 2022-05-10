package com.example.mycourseworkaston.data.remote.model.dataEpisodes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class EpisodeSingleRemote(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
) : Parcelable