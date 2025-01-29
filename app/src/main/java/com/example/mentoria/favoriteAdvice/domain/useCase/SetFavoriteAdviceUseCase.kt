package com.example.mentoria.favoriteAdvice.domain.useCase

import com.example.mentoria.core.utils.ResultData
import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.favoriteAdvice.domain.mapper.toDomain
import com.example.mentoria.favoriteAdvice.domain.mapper.toRemote
import com.example.mentoria.favoriteAdvice.domain.repository.FavoriteAdviceRepository
import com.example.mentoria.randomAdviceFeature.domain.mapper.toDomain
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.repository.AdviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
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