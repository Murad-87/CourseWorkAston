package com.example.mycourseworkaston.presentation.locationDetailsFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.FragmentLocationDetailsBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.CharactersAdapter
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.ItemClickCharacter
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
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
    }

    override fun onItemClick(character: CharacterUiModel) {
        TODO("Not yet implemented")
    }
}