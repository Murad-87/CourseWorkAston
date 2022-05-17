package com.example.mycourseworkaston.domain.useCase

import com.example.mycourseworkaston.domain.repository.CharacterRepository
import javax.inject.Inject

class FilterCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
){

}