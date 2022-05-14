package com.example.mycourseworkaston.data.local.converters

import com.example.mycourseworkaston.data.local.model.LocationLocalEntity
import com.example.mycourseworkaston.domain.model.LocationInfoDomainModel

fun LocationLocalEntity.toDomain() = LocationInfoDomainModel(
    id = id,
    name = name,
    residents = residents,
    type = type,
    dimension = dimension
)