package com.example.mycourseworkaston.di.app

import android.app.Application
import dagger.Component
import javax.inject.Singleton



@Component(modules = [ApplicationContextModule::class])
interface ApplicationComponent {

    fun applicationContext(): Application
}