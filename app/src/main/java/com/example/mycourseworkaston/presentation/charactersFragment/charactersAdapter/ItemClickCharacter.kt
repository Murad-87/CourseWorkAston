package com.example.mycourseworkaston.presentation.charactersFragment.charactersAdapter

import com.example.mycourseworkaston.data.remote.model.dataCharacters.CharacterSingleRemote

interface ItemClickCharacter {

    fun onItemClick(character: CharacterSingleRemote)
}