package com.example.mycourseworkaston.presentation.charactersFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseworkaston.domain.useCase.CharacterListUseCase
import com.example.mycourseworkaston.domain.useCase.FilterCharacterUseCase
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.CharacterUiModelFilter
import com.example.mycourseworkaston.presentation.model.converter.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val characterUseCase: CharacterListUseCase,
    private val characterFilterUseCase: FilterCharacterUseCase
) : ViewModel() {

    private val characterListMutable: MutableLiveData<List<CharacterUiModel>> =
        MutableLiveData()
    val characterList: LiveData<List<CharacterUiModel>> = characterListMutable
    private val isLoadingMutable: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = isLoadingMutable

    private val filteredMutableList: MutableLiveData<List<CharacterUiModel>> = MutableLiveData()
    val filteredList: LiveData<List<CharacterUiModel>> = filteredMutableList

    init {
        getCharacterList()
    }

    private fun getCharacterList() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                characterUseCase.getCharacterList()
            }.onSuccess { response ->
                isLoadingMutable.postValue(false)
                characterListMutable.postValue(response.map { it.toUi() })
            }.onFailure {
                isLoadingMutable.postValue(false)
            }
        }
    }

    fun getFilteredCharacters(filter: CharacterUiModelFilter) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = characterFilterUseCase.getFilteredCharactersList(filter)
            filteredMutableList.postValue(response.map { it.toUi() })
        }
    }

//    fun fetchData() {
//        filter = CharacterUiModelFilter()
//        viewModelScope.launch(Dispatchers.IO) {
//            isLoadingMutable.postValue(true)
//            val characters = characterFilterUseCase.getFilteredCharactersList()
//            isLoadingMutable.postValue(false)
//            characterListMutable.postValue(characters.map { it.toUi() })
//        }
//    }
//
//    fun getFilteredData(filter: CharacterUiModelFilter) {
//        this.filter = filter
//        viewModelScope.launch(Dispatchers.IO) {
//            isLoadingMutable.postValue(true)
//            val filteredCharacters =
//                characterFilterUseCase.getFilteredCharactersList(filter)
//            isLoadingMutable.postValue(false)
//            characterListMutable.postValue(filteredCharacters.map { it.toUi() })
//        }
//    }
}
