package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.repository.LocationRepository
import javax.inject.Inject

class FilterLocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {
}