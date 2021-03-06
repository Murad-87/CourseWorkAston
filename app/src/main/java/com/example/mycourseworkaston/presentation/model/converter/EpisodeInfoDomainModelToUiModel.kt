package com.example.mycourseworkaston.presentation.model.converter

import com.example.mycourseworkaston.domain.model.EpisodeInfoDomainModel
import com.example.mycourseworkaston.presentation.model.EpisodeUiModel

fun EpisodeInfoDomainModel.toUi() = EpisodeUiModel(
    id = id,
    air_date = air_date,
    characters = characters,
    episode = episode,
    name = name,
    created = created,
    url = url
)