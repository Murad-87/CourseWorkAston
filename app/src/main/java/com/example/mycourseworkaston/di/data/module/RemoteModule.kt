package com.example.mycourseworkaston.di.data.module

import com.example.mycourseworkaston.data.remote.api.APIService
import com.example.mycourseworkaston.data.remote.api.RetrofitInstance
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RemoteModule {

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRetrofitInstance(gsonConverterFactory: GsonConverterFactory): RetrofitInstance {
        return RetrofitInstance
    }

    @Provides
    fun provideAPIService(retrofitInstance: RetrofitInstance): APIService = retrofitInstance.api
}