package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.local.converters.toDomain
import com.example.mycourseworkaston.data.local.dao.LocationDao
import com.example.mycourseworkaston.data.remote.api.ApiServiceLocation
import com.example.mycourseworkaston.data.repository.mapper.LocationRemoteToLocationLocal
import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel
import com.example.mycourseworkaston.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val api: ApiServiceLocation,
    private val dao: LocationDao,
    private val mapperLocation: LocationRemoteToLocationLocal
) : LocationRepository {

    suspend fun loadDataLocationList() {
        var response = api.getLocationList()
        for (i in response.results) {
            dao.insertLocation(mapperLocation.mapLocation(i))
        }
        for (i in 2..response.info.pages) {

            response = api.getLocationList(i)
            for (j in response.results) {
                dao.insertLocation(mapperLocation.mapLocation(j))
            }
        }
    }

    override suspend fun getLocationList(): List<LocationInfoDomainModel> {
        var dataLocation = dao.getLocationList()
        return if (dataLocation.isNotEmpty()) {
            dataLocation.map { it.toDomain() }
        } else {
            loadDataLocationList()
            dataLocation = dao.getLocationList()
            dataLocation.map { it.toDomain() }
        }
    }

    override suspend fun getLocationListFilter(): List<LocationInfoDomainModel> {
        TODO("Not yet implemented")
    }
}