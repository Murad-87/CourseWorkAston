package com.example.mycourseworkaston.presentation.model.converter

import com.example.mycourseworkaston.presentation.model.CharacterUiModel
import com.example.mycourseworkaston.presentation.model.CharacterUiModelFilter

fun CharacterUiModel.toFilter() = CharacterUiModelFilter(
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender
)