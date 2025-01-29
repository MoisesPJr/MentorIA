package com.example.mentoria.favoriteAdvice.domain.repository

import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import kotlinx.coroutines.flow.Flow

interface FavoriteAdviceRepository {
    suspend fun deleteFavoriteAdvice(advice: AdviceEntityRemote)
    suspend fun setFavoriteAdvice(advice: AdviceEntityRemote)
    suspend fun getFavoriteAdvice(): List<AdviceEntityRemote>

}