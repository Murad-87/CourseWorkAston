package com.example.mycourseworkaston.presentation.charactersFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.FragmentCharactersBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.MainActivity
import com.example.mycourseworkaston.presentation.characterDetailsFragment.CharacterDetailsFragment
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.CharactersAdapter
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.ItemClickCharacter
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.utils.BaseFragment
import com.example.mycourseworkaston.utils.openKeyboard
import javax.inject.Inject

class CharactersFragment :
    BaseFragment<FragmentCharactersBinding>(FragmentCharactersBinding::inflate),
    ItemClickCharacter {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: CharactersViewModel by viewModels { viewModelFactory }
    private val adapter: CharactersAdapter by lazy { CharactersAdapter(this) }
    private var characterList: List<CharacterUiModel> = listOf()


    override fun onAttach(context: Context) {
        val component = (requireActivity().application as RickAndMortyApplication).component
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        showLoading()

        viewModel.characterList.observe(viewLifecycleOwner) {
            characterList = it
            adapter.submitList(it)
            Log.d("TESTING", "characterList")
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding) {
            characterFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            characterFragmentRecyclerView.adapter = adapter
        }
    }

    private fun initViews() {
        with(binding){
            charactersFragmentSearch.setOnClickListener {
                characterFragmentSearchEditText.requestFocus()
                characterFragmentSearchEditText.openKeyboard(requireContext())
            }
            characterFragmentSearchEditText.addTextChangedListener { searchItem(it.toString()) }
        }
    }

    private fun searchItem(query: String) {
        val filteredList = characterList.filter {
            it.name.contains(query) || it.status.contains(query) || it.gender.contains(query)
        }
        adapter.submitList(filteredList)
    }

    override fun onItemClick(character: CharacterUiModel) {
        TODO("Not yet implemented")
    }

    private fun showLoading() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            with(binding) {
                paginationProgressBarCharacter.isVisible = isLoading
                characterFragmentSearchImage.isVisible = !isLoading

            }
        }
    }

    private fun openDetails(detailsFragment: CharacterDetailsFragment) {
        (requireActivity() as MainActivity).openFragment(detailsFragment)
    }

    companion object {

        private const val CHARACTER_DATA = "CHARACTER_DATA"


    }
}