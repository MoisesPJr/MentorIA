package com.example.mentoria.randomAdviceFeature.domain.repository

import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import kotlinx.coroutines.flow.Flow

interface AdviceRepository {
    suspend fun getAdvice():Flow<AdviceRemote>
}