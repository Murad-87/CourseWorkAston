package com.example.mycourseworkaston.data.remote.model.dataLocations

import androidx.annotation.Keep

@Keep
data class LocationsRemoteList(
    val info: Info,
    val results: List<LocationSingleRemote>
)