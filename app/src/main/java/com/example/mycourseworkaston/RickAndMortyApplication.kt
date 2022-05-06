package com.example.mycourseworkaston

import android.app.Application
import com.example.mycourseworkaston.di.app.ApplicationComponent
import com.example.mycourseworkaston.di.app.ApplicationContextModule
import com.example.mycourseworkaston.di.app.DaggerApplicationComponent

class RickAndMortyApplication: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    private fun initComponent(){
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationContextModule(ApplicationContextModule(this))
            .build()

    }
}