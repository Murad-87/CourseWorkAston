package com.example.mycourseworkaston.presentation.characterDetailsFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mycourseworkaston.R
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.FragmentCharacterDetailsBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.EpisodesAdapter
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.ItemClickEpisode
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.EpisodeUiModel
import com.example.mycourseworkaston.utils.BaseFragment
import javax.inject.Inject

class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding>(FragmentCharacterDetailsBinding::inflate),
    ItemClickEpisode {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: CharacterDetailsViewModel by viewModels { viewModelFactory }
    private val adapter: EpisodesAdapter by lazy { EpisodesAdapter(this) }

    override fun onAttach(context: Context) {
        val component = (requireActivity().application as RickAndMortyApplication).component
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViews()
        initRecyclerView()
    }

    private fun initViews(){
        with(binding){
            val character = requireArguments().getParcelable<CharacterUiModel>(DETAILS_DATA)
            if (character != null) {
                Glide
                    .with(requireContext())
                    .load(character.image)
                    .into(detailsCharacterImage)
                detailsCharacterName.text = character.name
                detailsCharacterStatus.text = character.status
                detailsCharacterSpecies.text = character.species
                detailsCharacterGender.text = character.gender
            }
        }
    }

    private fun initRecyclerView(){
        with(binding){
            recyclerViewCharacterDetails.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewCharacterDetails.adapter = adapter
        }
    }

    override fun onItemClick(episode: EpisodeUiModel) {
        TODO("Not yet implemented")
    }

    private fun initToolbar(){
        with(binding){
            detailsCharacterToolbar.toolbarTitleText.text = getString(R.string.details_character_title_text)
            detailsCharacterToolbar.toolbarNavigateBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    companion object {

        private const val DETAILS_DATA = "DETAILS_DATA"

        fun newInstance(character: CharacterUiModel) =
            CharacterDetailsFragment().apply {
                arguments = bundleOf(
                    DETAILS_DATA to character
                )
            }
    }
}