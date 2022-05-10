package com.example.mycourseworkaston.di.presentation.component

import com.example.mycourseworkaston.di.domain.component.DomainComponent
import com.example.mycourseworkaston.di.presentation.module.ViewModelFactory
import dagger.Component

@Component(dependencies = [DomainComponent::class])
interface PresentationComponent {

    fun provideViewModelFactory(): ViewModelFactory
}