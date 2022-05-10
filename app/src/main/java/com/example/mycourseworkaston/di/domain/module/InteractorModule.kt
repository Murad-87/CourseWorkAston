package com.example.mycourseworkaston.di.domain.module

import com.example.mycourseworkaston.data.repository.RickAndMortyRepository
import com.example.mycourseworkaston.domain.CharacterUseCase
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideCharacterUseCase(repository: RickAndMortyRepository) : CharacterUseCase{
        return CharacterUseCase(repository)
    }
}