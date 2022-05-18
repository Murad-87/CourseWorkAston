package com.example.mycourseworkaston.presentation.episodesFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote
import com.example.mycourseworkaston.databinding.FragmentEpisodesBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.EpisodesAdapter
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.ItemClickEpisode
import com.example.mycourseworkaston.utils.BaseFragment
import javax.inject.Inject

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding>(FragmentEpisodesBinding::inflate),
    ItemClickEpisode {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EpisodesViewModel by viewModels { viewModelFactory }
    private val adapter: EpisodesAdapter by lazy { EpisodesAdapter(this) }

    override fun onAttach(context: Context) {
        val component = (requireActivity().application as RickAndMortyApplication).component
        component.inject(this)
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
  //      initRecyclerView()
    }

//    private fun initRecyclerView() {
//        TODO("Not yet implemented")
//    }


    override fun onItemClick(episode: EpisodeSingleRemote) {
        TODO("Not yet implemented")
    }


    companion object {

        private const val EPISODE_DATA = "EPISODE_DATA"
    }

}