package com.mjtech.mentoria.randomAdviceFeature.domain.source

import com.mjtech.mentoria.randomAdviceFeature.data.model.AdviceRemote

interface AdviceDataSource {
    suspend fun getAdvice():AdviceRemote
}