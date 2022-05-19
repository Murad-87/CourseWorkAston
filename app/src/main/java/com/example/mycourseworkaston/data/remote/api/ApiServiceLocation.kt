package com.example.mycourseworkaston.data.remote.api

import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationsRemoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceLocation {

    @GET("location/")
    suspend fun getLocationList(
        @Query("page") page: Int = 1
    ): LocationsRemoteList

    @GET("location/")
    suspend fun getLocationListFilter(
        @Query("name") name: String = "",
        @Query("type") type: String = "",
        @Query("dimension") dimension: String = ""
    ): LocationsRemoteList
}