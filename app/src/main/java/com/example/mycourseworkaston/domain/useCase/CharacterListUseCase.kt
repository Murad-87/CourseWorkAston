package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterListUseCase @Inject constructor(private val repository: CharacterRepository) {

    suspend fun getCharacterList(): List<CharacterInfoDomainModel> {
        return repository.getCharacterList()
    }
}