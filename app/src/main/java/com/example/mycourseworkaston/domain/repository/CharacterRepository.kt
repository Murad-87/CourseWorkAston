package com.example.mycourseworkaston.domain.repository

import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.presentation.model.CharacterUiModelFilter


interface CharacterRepository {

    suspend fun getCharacterList(): List<CharacterInfoDomainModel>

    suspend fun getCharacterListFilter(filter: CharacterUiModelFilter) : List<CharacterInfoDomainModel>
}