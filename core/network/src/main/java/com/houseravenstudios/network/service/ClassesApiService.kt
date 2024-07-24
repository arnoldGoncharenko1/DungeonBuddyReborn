package com.houseravenstudios.network.service

import com.houseravenstudios.network.models.ClassList
import retrofit2.http.GET

interface ClassesApiService {
    @GET("classes")
    suspend fun getClasses(): ClassList
}