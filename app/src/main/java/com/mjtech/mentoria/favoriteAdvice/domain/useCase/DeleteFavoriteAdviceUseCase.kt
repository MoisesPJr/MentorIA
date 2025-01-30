package com.mjtech.mentoria.favoriteAdvice.domain.useCase

import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.mjtech.mentoria.favoriteAdvice.domain.mapper.toRemote
import com.mjtech.mentoria.favoriteAdvice.domain.repository.FavoriteAdviceRepository
import com.mjtech.mentoria.favoriteAdvice.domain.useCase.DeleteFavoriteAdviceUseCase.Params
import javax.inject.Inject

interface DeleteFavoriteAdviceUseCase {
    suspend operator fun invoke(params: Params)
    data class Params(val adviceEntity: AdviceEntity)
}

class DeleteFavoriteAdviceUseCaseImpl @Inject constructor(
    private val adviceRepository: FavoriteAdviceRepository
) : DeleteFavoriteAdviceUseCase {
    override suspend fun invoke(params: Params) {
       adviceRepository.deleteFavoriteAdvice(params.adviceEntity.toRemote())
    }
}