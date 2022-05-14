package com.example.mycourseworkaston.data.local.converters

import com.example.mycourseworkaston.data.local.model.CharacterLocalEntity
import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel

fun CharacterInfoDomainModel.toEntity() = CharacterLocalEntity(
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