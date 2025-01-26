package com.example.mentoria.randomAdviceFeature.domain.source

import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote

interface AdviceDataSource {
    suspend fun getAdvice():AdviceRemote
}