package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import com.example.mycourseworkaston.domain.repository.LocationRepository
import javax.inject.Inject

class LocationListUseCase @Inject constructor(
    private val repository: LocationRepository
) {

    suspend fun getLocationList(): List<LocationInfoDomainModel>{
        return repository.getLocationList()
    }
}