package com.example.mycourseworkaston.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycourseworkaston.presentation.characterDetailsFragment.CharacterDetailsViewModel
import com.example.mycourseworkaston.presentation.charactersFragment.CharactersViewModel
import com.example.mycourseworkaston.presentation.episodeDetailsFragment.EpisodeDetailsViewModel
import com.example.mycourseworkaston.presentation.episodesFragment.EpisodesViewModel
import com.example.mycourseworkaston.presentation.locationDetailsFragment.LocationDetailsViewModel
import com.example.mycourseworkaston.presentation.locationsFragment.LocationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    fun bindCharactersViewModel(charactersViewModel: CharactersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    fun bindCharacterDetailsViewModel(characterDetailsViewModel: CharacterDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EpisodesViewModel::class)
    fun bindEpisodesViewModel(episodesViewModel: EpisodesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EpisodeDetailsViewModel::class)
    fun bindEpisodesDetailsViewModel(episodeDetailsViewModel: EpisodeDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LocationsViewModel::class)
    fun bindLocationsViewModel(locationsViewModel: LocationsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LocationDetailsViewModel::class)
    fun bindLocationDetailsViewModel(locationDetailsViewModel: LocationDetailsViewModel): ViewModel
}