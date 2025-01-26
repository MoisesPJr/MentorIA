package com.example.mentoria.randomAdviceFeature.data.service

import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import retrofit2.http.GET

interface AdviceApi {

    @GET("advice")
    suspend fun getAdvice(): AdviceRemote
}