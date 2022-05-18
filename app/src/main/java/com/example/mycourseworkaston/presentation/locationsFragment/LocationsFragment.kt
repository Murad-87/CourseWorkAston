package com.example.mycourseworkaston.presentation.locationsFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.FragmentLocationsBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.locationsFragment.locationsAdapter.ItemClickLocation
import com.example.mycourseworkaston.presentation.locationsFragment.locationsAdapter.LocationsAdapter
import com.example.mycourseworkaston.presentation.model.LocationUiModel
import com.example.mycourseworkaston.utils.BaseFragment
import com.example.mycourseworkaston.utils.openKeyboard
import javax.inject.Inject

class LocationsFragment :
    BaseFragment<FragmentLocationsBinding>(FragmentLocationsBinding::inflate), ItemClickLocation {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: LocationsViewModel by viewModels { viewModelFactory }
    private val adapter: LocationsAdapter by lazy { LocationsAdapter(this) }
    private var locationList: List<LocationUiModel> = listOf()

    override fun onAttach(context: Context) {
        val component = (requireActivity().application as RickAndMortyApplication).component
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewsLocation()
        showLoadingLocation()

        viewModel.locationList.observe(viewLifecycleOwner) {
            locationList = it
            adapter.submitList(it)
        }
        initRecyclerViewLocation()
    }

    private fun showLoadingLocation() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            with(binding) {
                paginationProgressBarLocations.isVisible = isLoading
                locationFragmentSearchImage.isVisible = !isLoading
            }
        }
    }

    private fun initViewsLocation() {
        with(binding) {
            locationsFragmentSearch.setOnClickListener {
                locationFragmentSearchEditText.requestFocus()
                locationFragmentSearchEditText.openKeyboard(requireContext())
            }
            locationFragmentSearchEditText.addTextChangedListener { searchItemLocation(it.toString()) }
        }
    }

    private fun searchItemLocation(query: String) {
        val filteredList = locationList.filter {
            it.name.contains(query) || it.type.contains(query)
        }
        adapter.submitList(filteredList)
    }

    private fun initRecyclerViewLocation() {
        with(binding) {
            locationsFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            locationsFragmentRecyclerView.adapter = adapter
        }
    }

    override fun onItemClick(location: LocationUiModel) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val LOCATION_DATA = "LOCATION_DATA"
    }
}