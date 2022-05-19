package com.example.mycourseworkaston.presentation.characterDetailsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseworkaston.domain.useCase.EpisodeListUseCase
import com.example.mycourseworkaston.domain.useCase.FilterCharacterUseCase
import com.example.mycourseworkaston.domain.useCase.FilterLocationUseCase
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.LocationUiModel
import com.example.mycourseworkaston.presentation.model.converter.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val useCaseEpisode: EpisodeListUseCase,
    private val useCase: FilterLocationUseCase,
) : ViewModel() {

    private val characterByIdMutable: MutableLiveData<CharacterUiModel> = MutableLiveData()
    val characterById: LiveData<CharacterUiModel> = characterByIdMutable

    private val _filteredLocations: MutableLiveData<List<LocationUiModel>> = MutableLiveData()
    val filteredLocations: LiveData<List<LocationUiModel>> = _filteredLocations

//    fun getCharacterLocations(name: String, type: String, dimen: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val res = useCase.getFilteredLocations(name, type, dimen)
//            _filteredLocations.postValue(res.map { it.toUi() })
//        }
//    }
}