package com.example.mycourseworkaston.presentation.charactersFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.FragmentCharactersBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.characterDetailsFragment.CharacterDetailsFragment
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.CharactersAdapter
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.ItemClickCharacter
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.utils.BaseFragment
import javax.inject.Inject

class CharactersFragment :
    BaseFragment<FragmentCharactersBinding>(FragmentCharactersBinding::inflate),
    ItemClickCharacter {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: CharactersViewModel by viewModels { viewModelFactory }
    private val adapter: CharactersAdapter by lazy { CharactersAdapter(this) }


    override fun onAttach(context: Context) {
        val component = (requireActivity().application as RickAndMortyApplication).component
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        showLoading()

        viewModel.characterList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        with(binding) {
            characterFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            characterFragmentRecyclerView.adapter = adapter
        }
    }


    override fun onItemClick(character: CharacterUiModel) {
        TODO("Not yet implemented")
    }

    private fun showLoading() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            with(binding) {
                paginationProgressBarCharacters.isVisible = isLoading
                characterFragmentSearchImage.isVisible = !isLoading

            }
        }
    }

//    private fun setupRecyclerView() {
//        binding.characterFragmentRecyclerView.apply {
//            adapter = adapter
//            layoutManager = GridLayoutManager(requireContext(), 2)
//
//        }
//    }

    private fun openDetails(detailsCharacter: CharacterDetailsFragment) {

    }

    companion object {

        private const val CHARACTER_DATA = "CHARACTER_DATA"


    }


}