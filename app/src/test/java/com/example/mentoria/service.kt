package com.example.mentoria

import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.example.mentoria.randomAdviceFeature.data.service.AdviceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Service(
    private val service: AdviceApi
) {

    suspend fun getAdvice(): AdviceRemote {
        return withContext(Dispatchers.IO) {
            val response = service.getAdvice()
            response
        }
    }

}