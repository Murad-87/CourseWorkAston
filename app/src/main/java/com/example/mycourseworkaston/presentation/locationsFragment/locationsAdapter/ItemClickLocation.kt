package com.example.mycourseworkaston.presentation.locationsFragment.locationsAdapter

import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote

interface ItemClickLocation {

    fun onItemClick(location: LocationSingleRemote)
}