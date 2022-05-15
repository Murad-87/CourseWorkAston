package com.example.mycourseworkaston.di

import com.example.mycourseworkaston.data.remote.api.ApiServiceCharacter
import com.example.mycourseworkaston.data.remote.api.ApiServiceEpisode
import com.example.mycourseworkaston.data.remote.api.ApiServiceLocation
import com.example.mycourseworkaston.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RemoteModule {

    @Provides
    @ApplicationScope
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @ApplicationScope
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideApiServiceCharacter(retrofit: Retrofit): ApiServiceCharacter = retrofit.create(ApiServiceCharacter::class.java)

    @Provides
    @ApplicationScope
    fun provideApiServiceEpisode(retrofit: Retrofit): ApiServiceEpisode = retrofit.create(ApiServiceEpisode::class.java)

    @Provides
    @ApplicationScope
    fun provideApiServiceLocation(retrofit: Retrofit): ApiServiceLocation= retrofit.create(ApiServiceLocation::class.java)
}