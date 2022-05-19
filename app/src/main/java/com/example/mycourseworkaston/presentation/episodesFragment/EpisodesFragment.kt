package com.example.mycourseworkaston.presentation.episodesFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.FragmentEpisodesBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.MainActivity
import com.example.mycourseworkaston.presentation.episodeDetailsFragment.EpisodeDetailsFragment
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.EpisodesAdapter
import com.example.mycourseworkaston.presentation.episodesFragment.episodesAdapter.ItemClickEpisode
import com.example.mycourseworkaston.presentation.model.EpisodeUiModel
import com.example.mycourseworkaston.utils.BaseFragment
import com.example.mycourseworkaston.utils.openKeyboard
import javax.inject.Inject

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding>(FragmentEpisodesBinding::inflate),
    ItemClickEpisode {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EpisodesViewModel by viewModels { viewModelFactory }
    private val adapter: EpisodesAdapter by lazy { EpisodesAdapter(this) }
    private var episodeList: List<EpisodeUiModel> = listOf()

    override fun onAttach(context: Context) {
        val component = (requireActivity().application as RickAndMortyApplication).component
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewsEpisode()
        showLoadingEpisode()

        viewModel.episodeList.observe(viewLifecycleOwner) {
            episodeList = it
            adapter.submitList(it)
        }
        initRecyclerViewEpisode()
    }

    private fun initRecyclerViewEpisode() {
        with(binding) {
            episodeFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            episodeFragmentRecyclerView.adapter = adapter
        }
    }

    private fun initViewsEpisode() {
        with(binding) {
            episodesFragmentSearch.setOnClickListener {
                episodeFragmentSearchEditText.requestFocus()
                episodeFragmentSearchEditText.openKeyboard(requireContext())
            }
            episodeFragmentSearchEditText.addTextChangedListener { searchItemEpisode(it.toString()) }
        }
    }

    private fun searchItemEpisode(query: String) {
        val filteredList = episodeList.filter {
            it.name.contains(query) || it.episode.contains(query)
        }
        adapter.submitList(filteredList)
    }

    private fun showLoadingEpisode() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            with(binding) {
                paginationProgressBarEpisode.isVisible = isLoading
                episodeFragmentSearchImage.isVisible = !isLoading

            }
        }
    }

    override fun onItemClick(episode: EpisodeUiModel) {
        openEpisodeDetails(EpisodeDetailsFragment.newInstance(episode))
    }

    private fun openEpisodeDetails(detailsFragment: EpisodeDetailsFragment){
        (requireActivity() as MainActivity).openFragment(detailsFragment)

    }

    companion object {

        private const val EPISODE_DATA = "EPISODE_DATA"

        fun newInstance(episode: EpisodeUiModel) =
            EpisodesFragment().apply {
                arguments = bundleOf(
                    EPISODE_DATA to episode
                )
            }
    }
}