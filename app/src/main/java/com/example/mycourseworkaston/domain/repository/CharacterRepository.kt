package com.example.mycourseworkaston.domain.repository

import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote
import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel

interface CharacterRepository {

    suspend fun getCharacterList(): List<CharacterInfoDomainModel>

    suspend fun getCharacterItem(itemId: Int): CharacterInfoDomainModel

    suspend fun  insertCharacter(characterRemote: CharacterSingleRemote)
}