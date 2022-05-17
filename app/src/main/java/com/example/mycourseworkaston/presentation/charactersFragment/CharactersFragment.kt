package com.example.mycourseworkaston.presentation.charactersFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote
import com.example.mycourseworkaston.databinding.FragmentCharactersBinding
import com.example.mycourseworkaston.utils.ViewModelFactory
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.CharactersAdapter
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.ItemClickCharacter
import com.example.mycourseworkaston.utils.BaseFragment
import javax.inject.Inject

class CharactersFragment :
    BaseFragment<FragmentCharactersBinding>(FragmentCharactersBinding::inflate),
    ItemClickCharacter {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: CharactersViewModel by viewModels { viewModelFactory }
    private val adapter: CharactersAdapter by lazy { CharactersAdapter(this) }
    private val characterList: List<CharacterSingleRemote> = arrayListOf()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding) {
            adapter.submitList(characterList)
            characterFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            characterFragmentRecyclerView.adapter = adapter
        }
    }

    override fun onItemClick(character: CharacterSingleRemote) {
        TODO("Not yet implemented")
    }

    companion object {

        private const val CHARACTER_DATA = "CHARACTER_DATA"


    }

}