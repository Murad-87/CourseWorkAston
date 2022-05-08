package com.example.mycourseworkaston.presentation.charactersFragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycourseworkaston.databinding.FragmentCharactersBinding
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.CharactersAdapter
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.ItemClickCharacter
import com.example.mycourseworkaston.utils.BaseFragment

class CharactersFragment :
    BaseFragment<FragmentCharactersBinding>(FragmentCharactersBinding::inflate),
    ItemClickCharacter {

    private val adapter: CharactersAdapter by lazy { CharactersAdapter(this) }
    private val characterList: List<CharacterSingleRemote> = arrayListOf()
    private val viewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding) {
            adapter.submitList(characterList)
            characterFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            characterFragmentRecyclerView.adapter = adapter
            viewModel.getCharacterAll()
        }
    }

    override fun onItemClick(character: CharacterSingleRemote) {
        TODO("Not yet implemented")
    }


}