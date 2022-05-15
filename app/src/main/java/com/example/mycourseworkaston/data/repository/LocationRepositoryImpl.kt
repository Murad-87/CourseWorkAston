package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel
import com.example.mycourseworkaston.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor() : LocationRepository {

    override suspend fun getLocationList(): List<LocationInfoDomainModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getLocationItem(itemId: Int): LocationInfoDomainModel {
        TODO("Not yet implemented")
    }
}