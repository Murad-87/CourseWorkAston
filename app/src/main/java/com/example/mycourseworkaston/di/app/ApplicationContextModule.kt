package com.example.mycourseworkaston.di.app

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationContextModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application = application
}