package com.example.mycourseworkaston.presentation.model.converter

import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel
import com.example.mycourseworkaston.presentation.model.LocationUiModel

fun LocationInfoDomainModel.toUi() = LocationUiModel(
    id = id,
    name = name,
    residents = residents,
    type = type,
    dimension = dimension,
    created = created
)