package com.example.mycourseworkaston.domain.repository

import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote
import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel

interface LocationRepository {

    fun getLocationList(): List<LocationInfoDomainModel>

    fun getLocationItem(itemId: Int): LocationInfoDomainModel

    suspend fun insertLocation(locationRemote: LocationSingleRemote)
}