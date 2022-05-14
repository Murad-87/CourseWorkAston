package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.repository.LocationRepository
import javax.inject.Inject

class LocationItemUseCase @Inject constructor(
    private val repository: LocationRepository
) {
}