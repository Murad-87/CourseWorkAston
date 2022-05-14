package com.example.mycourseworkaston.data.local.converters

import com.example.mycourseworkaston.data.local.model.EpisodeLocalEntity
import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel

fun EpisodeLocalEntity.toDomain() = EpisodeInfoDomainModel(
    id = id,
    air_date = air_date,
    characters = characters,
    episode = episode,
    name = name
)