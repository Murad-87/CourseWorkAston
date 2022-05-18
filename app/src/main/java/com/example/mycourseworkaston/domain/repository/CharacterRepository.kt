package com.example.mycourseworkaston.domain.repository

import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel


interface CharacterRepository {

    suspend fun getCharacterList(): List<CharacterInfoDomainModel>

    fun getCharacterItem(itemId: Int): CharacterInfoDomainModel

}