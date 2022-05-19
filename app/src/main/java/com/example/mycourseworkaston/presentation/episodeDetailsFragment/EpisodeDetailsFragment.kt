package com.example.mycourseworkaston.presentation.episodeDetailsFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.example.mycourseworkaston.R
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.FragmentEpisodeDetailsBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.CharactersAdapter
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.ItemClickCharacter
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.EpisodeUiModel
import com.example.mycourseworkaston.utils.BaseFragment
import javax.inject.Inject

class EpisodeDetailsFragment :
    BaseFragment<FragmentEpisodeDetailsBinding>(FragmentEpisodeDetailsBinding::inflate),
    ItemClickCharacter {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EpisodeDetailsViewModel by viewModels { viewModelFactory }
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
            val episode = requireArguments().getParcelable<EpisodeUiModel>(EPISODE_DATA)
            if (episode != null){
                detailsEpisodeName.text = episode.name
                detailsEpisodeEpisode.text = episode.episode
                detailsEpisodeAirDate.text = episode.air_date
            }
        }
    }

    override fun onItemClick(character: CharacterUiModel) {
        TODO("Not yet implemented")
    }

    private fun initToolbar(){
        with(binding){
            detailsEpisodeToolbar.toolbarTitleText.text = getString(R.string.details_episode_title_text)
            detailsEpisodeToolbar.toolbarNavigateBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    companion object {

        private const val EPISODE_DATA = "EPISODE_DATA"

        fun newInstance(episode: EpisodeUiModel) =
            EpisodeDetailsFragment().apply {
                arguments = bundleOf(
                    EPISODE_DATA to episode
                )
            }
    }
}