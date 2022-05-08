package com.example.mycourseworkaston.presentation.charactersFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList
import com.example.mycourseworkaston.data.repository.RickAndMortyRepository
import kotlinx.coroutines.launch

class CharactersViewModel: ViewModel() {

    var repository = RickAndMortyRepository()
    private val characterList: MutableLiveData<CharacterRemoteList> = MutableLiveData()

    fun getCharacterAll (){
        viewModelScope.launch {
            characterList.value = repository.getCharacter()
        }
    }

}