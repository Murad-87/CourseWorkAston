package com.example.mycourseworkaston.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationUiModel(
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val dimension: String
): Parcelable
