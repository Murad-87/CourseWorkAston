package com.example.mycourseworkaston.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "location_table")
data class LocationLocalEntity(
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val dimension: String,
) : Parcelable
