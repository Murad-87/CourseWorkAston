package com.example.mycourseworkaston.presentation.charactersFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList
import com.example.mycourseworkaston.domain.useCase.CharacterItemUseCase
import com.example.mycourseworkaston.domain.useCase.CharacterListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val characterUseCase: CharacterListUseCase,
    private val characterItemUseCase: CharacterItemUseCase
) : ViewModel() {

    private val characterList: MutableLiveData<CharacterRemoteList> = MutableLiveData()


}