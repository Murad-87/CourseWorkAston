package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.CharacterUiModelFilter
import javax.inject.Inject

class FilterCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    suspend fun getFilteredCharactersList(filter: CharacterUiModelFilter): List<CharacterInfoDomainModel> {
        return repository.getCharacterListFilter(filter)
    }

}