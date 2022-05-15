package com.example.mycourseworkaston.domain.repository

import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel

interface CharacterRepository {

    suspend fun getCharacterList(): List<CharacterInfoDomainModel>

    suspend fun getCharacterItem(itemId: Int): CharacterInfoDomainModel
}