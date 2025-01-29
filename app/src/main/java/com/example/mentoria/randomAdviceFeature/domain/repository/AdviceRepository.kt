package com.example.mentoria.randomAdviceFeature.domain.repository

import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.example.mentoria.randomAdviceFeature.data.model.SlipRemote
import kotlinx.coroutines.flow.Flow

interface AdviceRepository {
    suspend fun getAdvice(): Flow<AdviceRemote>
}