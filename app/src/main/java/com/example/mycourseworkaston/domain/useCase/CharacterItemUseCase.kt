package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterItemUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    suspend fun getCharacterItem(characterItem: Int): CharacterInfoDomainModel{
        return repository.getCharacterItem(characterItem)
    }
}