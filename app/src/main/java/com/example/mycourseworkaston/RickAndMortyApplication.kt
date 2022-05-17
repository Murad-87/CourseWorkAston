package com.example.mycourseworkaston

import android.app.Application
import com.example.mycourseworkaston.di.DaggerApplicationComponent


class RickAndMortyApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}