package com.mjtech.mentoria.randomAdviceFeature.data.service

import com.mjtech.mentoria.randomAdviceFeature.data.model.AdviceRemote
import retrofit2.http.GET

interface AdviceApi {

    @GET("advice")
    suspend fun getAdvice(): AdviceRemote
}