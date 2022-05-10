package com.example.mycourseworkaston.domain

import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationsRemoteList
import com.example.mycourseworkaston.data.repository.RickAndMortyRepository

class LocationUseCase(private val repository: RickAndMortyRepository) {
    suspend fun get(): LocationsRemoteList{
        return repository.getLocation()
    }
}