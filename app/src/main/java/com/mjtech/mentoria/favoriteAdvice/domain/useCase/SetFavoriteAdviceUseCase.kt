package com.mjtech.mentoria.favoriteAdvice.domain.useCase

import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.mjtech.mentoria.favoriteAdvice.domain.mapper.toRemote
import com.mjtech.mentoria.favoriteAdvice.domain.repository.FavoriteAdviceRepository
import javax.inject.Inject

interface SetFavoriteAdviceUseCase {
    suspend operator fun invoke(params: Params)
    data class Params(val adviceEntity: AdviceEntity)
}

class SetFavoriteAdviceUseCaseImpl @Inject constructor(
    private val adviceRepository: FavoriteAdviceRepository
) : SetFavoriteAdviceUseCase {
    override suspend fun invoke(params: SetFavoriteAdviceUseCase.Params) {
       adviceRepository.setFavoriteAdvice(params.adviceEntity.toRemote())
    }
}