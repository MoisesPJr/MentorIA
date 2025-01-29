package com.example.mentoria.favoriteAdvice.data.repository

import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.favoriteAdvice.domain.repository.FavoriteAdviceRepository
import com.example.mentoria.favoriteAdvice.domain.source.FavoriteAdviceDataSource
import javax.inject.Inject

class FavoriteAdviceRepositoryImpl @Inject constructor(
    private val dataSource: FavoriteAdviceDataSource
) : FavoriteAdviceRepository {
    override suspend fun deleteFavoriteAdvice(advice: AdviceEntityRemote) {
        return dataSource.deleteFavoriteAdvice(advice)
    }

    override suspend fun setFavoriteAdvice(advice: AdviceEntityRemote) {
        return dataSource.setFavoriteAdvice(advice)
    }

    override suspend fun getFavoriteAdvice():List<AdviceEntityRemote> {
        return dataSource.getFavoriteAdvice()
    }


}