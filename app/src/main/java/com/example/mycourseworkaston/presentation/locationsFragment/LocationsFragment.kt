package com.example.mycourseworkaston.presentation.locationsFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.data.remote.model.dataLocations.LocationSingleRemote
import com.example.mycourseworkaston.databinding.FragmentLocationsBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.locationsFragment.locationsAdapter.ItemClickLocation
import com.example.mycourseworkaston.presentation.locationsFragment.locationsAdapter.LocationsAdapter
import com.example.mycourseworkaston.utils.BaseFragment
import javax.inject.Inject

class LocationsFragment :
    BaseFragment<FragmentLocationsBinding>(FragmentLocationsBinding::inflate), ItemClickLocation {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: LocationsViewModel by viewModels { viewModelFactory }
    private val adapter: LocationsAdapter by lazy { LocationsAdapter(this) }

    override fun onAttach(context: Context) {
        val component = (requireActivity().application as RickAndMortyApplication).component
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initRecyclerView()
    }

//    private fun initRecyclerView() {
//        TODO("Not yet implemented")
//    }




    override fun onItemClick(location: LocationSingleRemote) {
        TODO("Not yet implemented")
    }


    companion object{
         private const val LOCATION_DATA = "LOCATION_DATA"
    }
}