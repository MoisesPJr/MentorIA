package com.example.mentoria.randomAdviceFeature.domain.source

import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.example.mentoria.randomAdviceFeature.data.model.SlipRemote
import kotlinx.coroutines.flow.Flow

interface AdviceDataSource {
    suspend fun getAdvice():AdviceRemote
}