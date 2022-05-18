package com.example.mycourseworkaston.presentation.characterDetailsFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote
import com.example.mycourseworkaston.databinding.FragmentCharacterDetailsBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.EpisodesAdapter
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.ItemClickEpisode
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
    }

    override fun onItemClick(episode: EpisodeUiModel) {
        TODO("Not yet implemented")
    }
}