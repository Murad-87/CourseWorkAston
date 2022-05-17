package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel
import com.example.mycourseworkaston.domain.repository.LocationRepository
import javax.inject.Inject

class LocationItemUseCase @Inject constructor(
    private val repository: LocationRepository
) {

    suspend fun getLocationItem(locationItem: Int): LocationInfoDomainModel{
        return repository.getLocationItem(locationItem)
    }
}