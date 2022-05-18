package com.example.mycourseworkaston.domain.repository

import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel

interface LocationRepository {

    suspend fun getLocationList(): List<LocationInfoDomainModel>

    fun getLocationItem(itemId: Int): LocationInfoDomainModel

}