package com.example.mycourseworkaston

import android.app.Application


class RickAndMortyApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}