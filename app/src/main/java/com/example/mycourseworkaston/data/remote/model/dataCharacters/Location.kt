package com.example.mycourseworkaston.data.remote.model.dataCharacters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val name: String,
    val url: String
): Parcelable