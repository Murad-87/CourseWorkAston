package com.example.mycourseworkaston.presentation.charactersFragment

import androidx.lifecycle.*
import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.domain.useCase.CharacterListUseCase
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.converter.toUi
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val characterUseCase: CharacterListUseCase,
) : ViewModel() {

    private val characterListMutable: MutableLiveData<List<CharacterUiModel>> =
        MutableLiveData()
    val characterList: LiveData<List<CharacterUiModel>> = characterListMutable

    private val isLoadingMutable: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = isLoadingMutable

    init {
        getCharacterList()
    }

    private fun getCharacterList() {
        viewModelScope.launch {
            kotlin.runCatching {
                characterUseCase.getCharacterList()
            }.onSuccess { response ->
                isLoadingMutable.postValue(false)
                characterListMutable.postValue(response.map { it.toUi() })
            }.onFailure {
                isLoadingMutable.postValue(false)
            }
        }
//        kotlin.runCatching {
//            viewModelScope.launch {
//
//            }
//        }
//        viewModelScope.launch {
//            val response = characterUseCase.getCharacterList().map { it.toUi() }
//            characterListMutable.postValue(response)
//        }
    }
}
