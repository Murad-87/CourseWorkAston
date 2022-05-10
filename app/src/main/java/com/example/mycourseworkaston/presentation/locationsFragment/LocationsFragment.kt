package com.example.mycourseworkaston.presentation.locationsFragment

import android.os.Bundle
import android.view.View
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote
import com.example.mycourseworkaston.databinding.FragmentLocationsBinding
import com.example.mycourseworkaston.presentation.locationsFragment.locationsAdapter.ItemClickLocation
import com.example.mycourseworkaston.utils.BaseFragment

class LocationsFragment :
    BaseFragment<FragmentLocationsBinding>(FragmentLocationsBinding::inflate), ItemClickLocation {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    override fun onItemClick(location: LocationSingleRemote) {
        TODO("Not yet implemented")
    }


    companion object{
         private const val LOCATION_DATA = "LOCATION_DATA"
    }
}