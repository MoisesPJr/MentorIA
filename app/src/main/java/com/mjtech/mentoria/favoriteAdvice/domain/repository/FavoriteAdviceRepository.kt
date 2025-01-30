package com.mjtech.mentoria.favoriteAdvice.domain.repository

import com.mjtech.mentoria.favoriteAdvice.data.model.AdviceEntityRemote

interface FavoriteAdviceRepository {
    suspend fun deleteFavoriteAdvice(advice: AdviceEntityRemote)
    suspend fun setFavoriteAdvice(advice: AdviceEntityRemote)
    suspend fun getFavoriteAdvice(): List<AdviceEntityRemote>

}