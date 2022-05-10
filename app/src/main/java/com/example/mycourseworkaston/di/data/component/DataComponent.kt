package com.example.mycourseworkaston.di.data.component

import com.example.mycourseworkaston.data.repository.RickAndMortyRepository
import com.example.mycourseworkaston.di.app.ApplicationComponent
import com.example.mycourseworkaston.di.data.module.LocalModule
import com.example.mycourseworkaston.di.data.module.RemoteModule
import com.example.mycourseworkaston.di.data.module.RepositoryModule
import dagger.Component


@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        LocalModule::class,
        RemoteModule::class,
        RepositoryModule::class
    ]
)
interface DataComponent {
    fun provideRickAndMortyRepository(): RickAndMortyRepository
}