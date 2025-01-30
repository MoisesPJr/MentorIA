package com.mjtech.mentoria.randomAdviceFeature.domain.repository

import com.mjtech.mentoria.randomAdviceFeature.data.model.AdviceRemote
import kotlinx.coroutines.flow.Flow

interface AdviceRepository {
    suspend fun getAdvice(): Flow<AdviceRemote>
}