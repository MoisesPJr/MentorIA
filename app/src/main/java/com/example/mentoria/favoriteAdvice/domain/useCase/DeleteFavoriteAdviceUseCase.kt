package com.example.mentoria.favoriteAdvice.domain.useCase

import com.example.mentoria.core.utils.ResultData
import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.favoriteAdvice.domain.mapper.toDomain
import com.example.mentoria.favoriteAdvice.domain.mapper.toRemote
import com.example.mentoria.favoriteAdvice.domain.repository.FavoriteAdviceRepository
import com.example.mentoria.favoriteAdvice.domain.useCase.DeleteFavoriteAdviceUseCase.Params
import com.example.mentoria.randomAdviceFeature.domain.mapper.toDomain
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.repository.AdviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
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