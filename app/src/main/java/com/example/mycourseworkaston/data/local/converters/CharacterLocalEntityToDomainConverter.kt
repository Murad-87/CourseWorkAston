package com.example.mycourseworkaston.data.local.converters

import com.example.mycourseworkaston.data.local.model.CharacterLocalEntity
import com.example.mycourseworkaston.domain.model.CharacterInfoDomainModel

fun CharacterLocalEntity.toDomain() = CharacterInfoDomainModel(
    id = id,
    name = name,
    species = species,
    status = status,
    gender = gender,
    image = image,
    type = type,
    locationName = locationName,
    locationUrl = locationUrl,
    originName = originName,
    originUrl = originUrl,
    episode = episode
)