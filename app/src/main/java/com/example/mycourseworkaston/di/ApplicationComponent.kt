package com.example.mycourseworkaston.di

import android.app.Application
import com.example.mycourseworkaston.presentation.characterDetailsFragment.CharacterDetailsFragment
import com.example.mycourseworkaston.presentation.charactersFragment.CharactersFragment
import com.example.mycourseworkaston.presentation.episodeDetailsFragment.EpisodeDetailsFragment
import com.example.mycourseworkaston.presentation.episodesFragment.EpisodesFragment
import com.example.mycourseworkaston.presentation.locationDetailsFragment.LocationDetailsFragment
import com.example.mycourseworkaston.presentation.locationsFragment.LocationsFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [ViewModelModule::class, RemoteModule::class])
interface ApplicationComponent {

  fun inject(characterFragment: CharactersFragment)

  fun inject(characterDetailsFragment: CharacterDetailsFragment)

  fun inject(episodesFragment: EpisodesFragment)

  fun inject(episodeDetailsFragment: EpisodeDetailsFragment)

  fun inject(locationsFragment: LocationsFragment)

  fun inject(locationDetailsFragment: LocationDetailsFragment)

  @Component.Factory
  interface ApplicationBuilderFactory

    fun create(
        @BindsInstance application: Application
    ): Application
}