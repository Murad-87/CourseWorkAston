package com.example.mycourseworkaston.data.repository

import com.example.mycourseworkaston.data.local.converters.toDomain
import com.example.mycourseworkaston.data.local.dao.CharacterDao
import com.example.mycourseworkaston.data.remote.api.ApiServiceCharacter
import com.example.mycourseworkaston.data.remote.api.ApiServiceLocation
import com.example.mycourseworkaston.data.repository.mapper.CharacterRemoteToCharacterLocal
import com.example.mycourseworkaston.data.repository.mapper.LocationRemoteToLocationLocal
import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import com.example.mycourseworkaston.presentation.model.CharacterUiModelFilter
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: ApiServiceCharacter,
    private val dao: CharacterDao,
    private val mapperCharacter: CharacterRemoteToCharacterLocal,
) : CharacterRepository {


    private suspend fun loadDataCharacter() {
        var response = api.getCharacterList()
        for (i in response.results) {
            dao.insertCharacter(mapperCharacter.mapCharacter(i))
        }
        for (i in 2..response.info.pages) {

            response = api.getCharacterList(i)
            for (j in response.results) {
                dao.insertCharacter(mapperCharacter.mapCharacter(j))
            }
        }
    }

    override suspend fun getCharacterList(): List<CharacterInfoDomainModel> {
        var data = dao.getCharacterList()
        return if (data.isNotEmpty()) {
            data.map { it.toDomain() }
        } else {
            loadDataCharacter()
            data = dao.getCharacterList()
            data.map { it.toDomain() }
        }
    }

    override suspend fun getCharacterListFilter(filter: CharacterUiModelFilter): List<CharacterInfoDomainModel> {
        val filteredList = api.getCharactersListFilter(
            name = filter.name,
            status = filter.status,
            species = filter.species,
            type = filter.type,
            gender = filter.gender
        )
        return filteredList.results.map { mapperCharacter.mapCharacter(it) }.map { it.toDomain() }
    }

    suspend fun getCharacterLocations(name: String, type: String, dimension: String): List<LocationInfoDomainModel> {
//        val response = locationApi.getLocationListFilter(name, type, dimension)
//        return response.results.map { mapperLocation.mapLocation(it) }.map { it.toDomain()
        return listOf()
    }
}
