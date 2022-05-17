package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.local.dao.CharacterDao
import com.example.mycourseworkaston.data.remote.api.ApiServiceCharacter
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote
import com.example.mycourseworkaston.data.repository.mapper.CharacterRemoteToCharacterLocal
import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: ApiServiceCharacter,
    private val dao: CharacterDao,
    private val mapperCharacter: CharacterRemoteToCharacterLocal,

    ) : CharacterRepository {

    override suspend fun getCharacterList(): List<CharacterInfoDomainModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterItem(itemId: Int): CharacterInfoDomainModel {
        TODO("Not yet implemented")
    }

    override suspend fun insertCharacter(characterRemote: CharacterSingleRemote){
        characterRemote.let ( mapperCharacter::mapCharacter)
            .let { dao.insertCharacter(it) }
    }
}