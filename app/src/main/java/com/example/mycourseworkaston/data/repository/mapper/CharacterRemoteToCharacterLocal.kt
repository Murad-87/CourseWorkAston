package com.example.mycourseworkaston.data.repository.mapper

import com.example.mycourseworkaston.data.local.model.CharacterLocalEntity
import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote
import javax.inject.Inject

class CharacterRemoteToCharacterLocal @Inject constructor() {
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
                locationUrl = location.url,
                originName = origin.name,
                originUrl = origin.url,
                episode = episode
            )
        }
    }
}