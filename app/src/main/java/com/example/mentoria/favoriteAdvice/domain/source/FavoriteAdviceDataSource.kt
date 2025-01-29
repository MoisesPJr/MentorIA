package com.example.mentoria.favoriteAdvice.domain.source

import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote

interface FavoriteAdviceDataSource {
    suspend fun deleteFavoriteAdvice(advice: AdviceEntityRemote)
    suspend fun getFavoriteAdvice(): List<AdviceEntityRemote>
    suspend fun setFavoriteAdvice(advice: AdviceEntityRemote)

}