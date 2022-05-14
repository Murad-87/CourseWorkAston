package com.example.mycourseworkaston.data.remote.api

import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationsRemoteList
import retrofit2.http.GET

interface ApiServiceLocation {

    @GET("/location")
    suspend fun getLocations(): LocationsRemoteList
}