package com.example.mycourseworkaston.presentation.episodesFragment

import android.os.Bundle
import android.view.View
import com.example.mycourseworkaston.data.remote.model.dataEpisodes.EpisodeSingleRemote
import com.example.mycourseworkaston.databinding.FragmentEpisodesBinding
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.ItemClickEpisode
import com.example.mycourseworkaston.utils.BaseFragment

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding>(FragmentEpisodesBinding::inflate),
    ItemClickEpisode {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onItemClick(episode: EpisodeSingleRemote) {
        TODO("Not yet implemented")
    }


    companion object {

        private const val EPISODE_DATA = "EPISODE_DATA"
    }

}