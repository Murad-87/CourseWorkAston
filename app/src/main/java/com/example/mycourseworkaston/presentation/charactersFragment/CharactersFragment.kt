package com.example.mycourseworkaston.presentation.charactersFragment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycourseworkaston.R
import com.example.mycourseworkaston.RickAndMortyApplication
import com.example.mycourseworkaston.databinding.CharacterFilterDialogBinding
import com.example.mycourseworkaston.databinding.FragmentCharactersBinding
import com.example.mycourseworkaston.di.ViewModelFactory
import com.example.mycourseworkaston.presentation.MainActivity
import com.example.mycourseworkaston.presentation.characterDetailsFragment.CharacterDetailsFragment
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.CharactersAdapter
import com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter.ItemClickCharacter
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.CharacterUiModelFilter
import com.example.mycourseworkaston.utils.BaseFragment
import com.example.mycourseworkaston.utils.CharacterGender
import com.example.mycourseworkaston.utils.CharacterStatus
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
        filter()

        viewModel.characterList.observe(viewLifecycleOwner) {
            characterList = it
            adapter.submitList(it)
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
        with(binding) {
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
        openDetails(CharacterDetailsFragment.newInstance(character))
    }

    private fun showLoading() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.paginationProgressBarCharacter.isVisible = isLoading
        }
    }

    private fun openDetails(detailsFragment: CharacterDetailsFragment) {
        (requireActivity() as MainActivity).openFragment(detailsFragment)
    }

    private fun filter(){
        binding.characterFragmentFilter.setOnClickListener {
            initFilterDialog()
        }
    }

    private fun initFilterDialog() {
        val binding = CharacterFilterDialogBinding.inflate(layoutInflater)
        with(binding) {
            val listener = DialogInterface.OnClickListener { _, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                            CharacterUiModelFilter(
                                status = when (binding.characterFilterRadioGroupStatus.checkedRadioButtonId) {
                                    R.id.character_filter_status_alive -> CharacterStatus.ALIVE.value
                                    R.id.character_filter_status_dead -> CharacterStatus.DEAD.value
                                    R.id.character_filter_status_unknown -> CharacterStatus.UNKNOWN.value
                                    else -> ""
                                },
                                gender = when (binding.characterFilterRadioGroupGender.checkedRadioButtonId) {
                                    R.id.character_filter_gender_female -> CharacterGender.FEMALE.value
                                    R.id.character_filter_gender_male -> CharacterGender.MALE.value
                                    R.id.character_filter_gender_genderless -> CharacterGender.GENDERLESS.value
                                    R.id.character_filter_gender_unknown -> CharacterGender.UNKNOWN.value
                                    else -> ""
                                }
                            )
                    }
                    DialogInterface.BUTTON_NEGATIVE -> {}
                    DialogInterface.BUTTON_NEUTRAL -> {
                    }
                }
            }
            val dialog = AlertDialog.Builder(requireContext())
                .setCancelable(true)
                .setView(root)
                .setTitle(getString(R.string.dialog_characters_filter))
                .setPositiveButton(getString(R.string.apply), listener)
                .setNegativeButton(getString(R.string.cancel), listener)
                .setNeutralButton(getString(R.string.clear), listener)
                .create()
            dialog.show()
        }
    }

    companion object {

        private const val CHARACTER_DATA = "CHARACTER_DATA"

        fun newInstance(character: CharacterUiModel) =
            CharactersFragment().apply {
                arguments = bundleOf(
                    CHARACTER_DATA to character
                )
            }
    }
}