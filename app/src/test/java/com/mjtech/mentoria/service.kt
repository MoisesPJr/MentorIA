package com.mjtech.mentoria

import com.mjtech.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.mjtech.mentoria.randomAdviceFeature.data.service.AdviceApi
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