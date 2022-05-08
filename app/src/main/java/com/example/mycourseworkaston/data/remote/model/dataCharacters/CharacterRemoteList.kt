package com.example.mycourseworkaston.data.remote.model.dataCharacters

import androidx.annotation.Keep

@Keep
data class CharacterRemoteList(
    val info: Info,
    val results: List<CharacterSingleRemote>
)