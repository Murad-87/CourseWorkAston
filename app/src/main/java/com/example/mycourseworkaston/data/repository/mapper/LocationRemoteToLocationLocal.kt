package com.example.mycourseworkaston.data.repository.mapper

import com.example.mycourseworkaston.data.local.model.LocationLocalEntity
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote

class LocationRemoteToLocationLocal {
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