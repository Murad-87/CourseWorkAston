package com.example.mycourseworkaston.presentation.charactersFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList
import com.example.mycourseworkaston.data.repository.RickAndMortyRepository
import com.example.mycourseworkaston.domain.CharacterUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val characterUseCase: CharacterUseCase) :
    ViewModel() {

    private val characterList: MutableLiveData<CharacterRemoteList> = MutableLiveData()

    fun getCharacterAll() {
        viewModelScope.launch {
            characterList.value = characterUseCase.get()
        }
    }

}