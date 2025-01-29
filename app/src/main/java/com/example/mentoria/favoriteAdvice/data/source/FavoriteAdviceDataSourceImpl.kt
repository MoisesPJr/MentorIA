package com.example.mentoria.favoriteAdvice.data.source

import com.example.mentoria.favoriteAdvice.data.db.AdviceDao
import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.favoriteAdvice.domain.source.FavoriteAdviceDataSource
import javax.inject.Inject

class FavoriteAdviceDataSourceImpl @Inject constructor(
    private val adviceDao: AdviceDao
): FavoriteAdviceDataSource {
    override suspend fun setFavoriteAdvice(advice: AdviceEntityRemote) {
        adviceDao.insert(advice)
    }


    override suspend fun deleteFavoriteAdvice(advice: AdviceEntityRemote) {
        adviceDao.deleteFavoriteAdvice(advice.id)
    }

    override suspend fun getFavoriteAdvice(): List<AdviceEntityRemote> {
        return adviceDao.getAdvice()
    }

}