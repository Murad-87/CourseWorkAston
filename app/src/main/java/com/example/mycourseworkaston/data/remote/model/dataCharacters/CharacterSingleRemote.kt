package com.example.mycourseworkaston.data.remote.model.dataCharacters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterSingleRemote(
    val created: String,
    val episode: List<Any>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
): Parcelable