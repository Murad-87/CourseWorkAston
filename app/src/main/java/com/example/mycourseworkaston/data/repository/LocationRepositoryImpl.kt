package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.local.dao.LocationDao
import com.example.mycourseworkaston.data.remote.api.ApiServiceLocation
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote
import com.example.mycourseworkaston.data.repository.mapper.LocationRemoteToLocationLocal
import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel
import com.example.mycourseworkaston.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val api: ApiServiceLocation,
    private val dao: LocationDao,
    private val mapperLocation: LocationRemoteToLocationLocal
) : LocationRepository {

    override fun getLocationList(): List<LocationInfoDomainModel> {
        TODO("Not yet implemented")
    }

    override fun getLocationItem(itemId: Int): LocationInfoDomainModel {
        TODO("Not yet implemented")
    }

    override suspend fun insertLocation(locationRemote: LocationSingleRemote) {
        locationRemote.let(mapperLocation::mapLocation)
            .let { dao.insertLocation(it) }
    }

}