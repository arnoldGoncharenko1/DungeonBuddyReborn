package com.houseravenstudios.network.di

import com.houseravenstudios.network.service.ClassesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .baseUrl("https://www.dnd5eapi.co/api/")
            .build()

    @Provides
    @Singleton
    fun provideClassesApiService(retrofit: Retrofit): ClassesApiService =
        retrofit.create(ClassesApiService::class.java)
}