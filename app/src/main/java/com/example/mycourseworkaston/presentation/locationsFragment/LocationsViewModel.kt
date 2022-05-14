package com.example.mycourseworkaston.presentation.locationsFragment

import androidx.lifecycle.ViewModel
import com.example.mycourseworkaston.domain.useCase.LocationListUseCase
import javax.inject.Inject

class LocationsViewModel @Inject constructor(private val locationUseCase: LocationListUseCase) :
    ViewModel() {
}