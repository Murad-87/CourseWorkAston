package com.example.mycourseworkaston.data.repository.mapper

import com.example.mycourseworkaston.data.local.model.LocationLocalEntity
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote
import javax.inject.Inject

class LocationRemoteToLocationLocal @Inject constructor() {
    fun mapLocation(remoteLocation: LocationSingleRemote): LocationLocalEntity{
        with(remoteLocation){
            return LocationLocalEntity(
                id,
                name,
                residents,
                type,
                dimension
            )
        }
    }
}