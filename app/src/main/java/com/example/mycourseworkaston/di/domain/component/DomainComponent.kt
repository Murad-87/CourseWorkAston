package com.example.mycourseworkaston.di.domain.component

import com.example.mycourseworkaston.di.data.component.DataComponent
import com.example.mycourseworkaston.di.domain.module.InteractorModule
import com.example.mycourseworkaston.domain.CharacterUseCase
import dagger.Component

@Component(dependencies = [DataComponent::class], modules = [InteractorModule::class])
interface DomainComponent {

    fun provideCharacterUseCase(): CharacterUseCase
}