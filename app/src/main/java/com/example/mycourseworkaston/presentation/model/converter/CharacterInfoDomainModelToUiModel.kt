package com.example.mycourseworkaston.presentation.model.converter

import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel
import com.example.mycourseworkaston.presentation.model.CharacterUiModel

fun CharacterInfoDomainModel.toUi() = CharacterUiModel(
    id = id,
    name = name,
    species = species,
    status = status,
    gender = gender,
    image = image,
    type = type,
    locationName = locationName,
    originName = originName
)