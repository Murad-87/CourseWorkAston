package com.example.mycourseworkaston.presentation.characterDetailsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseworkaston.domain.useCase.EpisodeListUseCase
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val useCaseEpisode: EpisodeListUseCase
) : ViewModel() {

    private val characterByIdMutable: MutableLiveData<CharacterUiModel> = MutableLiveData()
    val characterById: LiveData<CharacterUiModel> = characterByIdMutable


}