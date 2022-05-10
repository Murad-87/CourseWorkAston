package com.example.mycourseworkaston.data.repository.mapper

import com.example.mycourseworkaston.data.local.model.CharacterLocalEntity
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote

class CharacterRemoteToCharacterLocal {
    fun mapCharacter(remoteCharacter: CharacterSingleRemote): CharacterLocalEntity {
        with(remoteCharacter) {
            return CharacterLocalEntity(
                id,
                name,
                species,
                status,
                gender,
                image,
                type,
                locationName = location.name,
                originName = origin.name
            )
        }
    }
}