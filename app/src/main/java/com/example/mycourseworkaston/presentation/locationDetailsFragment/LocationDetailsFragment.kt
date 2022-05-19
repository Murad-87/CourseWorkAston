package com.example.mycourseworkaston.presentation.locationDetailsFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.example.mycourseworkaston.R
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.FragmentLocationDetailsBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.CharactersAdapter
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.ItemClickCharacter
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.LocationUiModel
import com.example.mycourseworkaston.utils.BaseFragment
import javax.inject.Inject

class LocationDetailsFragment :
    BaseFragment<FragmentLocationDetailsBinding>(FragmentLocationDetailsBinding::inflate),
    ItemClickCharacter {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: LocationDetailsViewModel by viewModels { viewModelFactory }
    private val adapter: CharactersAdapter by lazy { CharactersAdapter(this) }

    override fun onAttach(context: Context) {
        val component = (requireActivity().application as RickAndMortyApplication).component
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViews()
    }

    private fun initViews(){
        with(binding){
            val location = requireArguments().getParcelable<LocationUiModel>(LOCATION_DATA)
            if (location != null){
                detailsLocationName.text = location.name
                detailsLocationDimension.text = location.dimension
                detailsLocationType.text = location.type
            }
        }
    }

    override fun onItemClick(character: CharacterUiModel) {
        TODO("Not yet implemented")
    }

    private fun initToolbar(){
        with(binding){
            detailsLocationToolbar.toolbarTitleText.text = getString(R.string.details_location_title_text)
            detailsLocationToolbar.toolbarNavigateBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    companion object{

        private const val LOCATION_DATA = "LOCATION_DATA"

        fun newInstance(location: LocationUiModel) =
            LocationDetailsFragment().apply {
                arguments = bundleOf(
                    LOCATION_DATA to location
                )
            }
    }
}