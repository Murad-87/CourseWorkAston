package com.example.mycourseworkaston.domain.useCase

import android.util.Log
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterRemoteList
import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterListUseCase @Inject constructor(private val repository: CharacterRepository) {

    suspend fun getCharacterList(): List<CharacterInfoDomainModel> {
        Log.d("TESTING", "getCharacterList() use case")
        return repository.getCharacterList()
    }
}