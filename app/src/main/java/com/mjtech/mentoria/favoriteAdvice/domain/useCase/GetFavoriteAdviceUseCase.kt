package com.mjtech.mentoria.favoriteAdvice.domain.useCase

import com.mjtech.mentoria.core.utils.ResultData
import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.mjtech.mentoria.favoriteAdvice.domain.mapper.toDomain
import com.mjtech.mentoria.favoriteAdvice.domain.repository.FavoriteAdviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetFavoriteAdviceUseCase {
    suspend operator fun invoke(): Flow<ResultData<List<AdviceEntity>>>
}

class GetFavoriteAdviceUseCaseImpl @Inject constructor(
    private val adviceRepository: FavoriteAdviceRepository
) : GetFavoriteAdviceUseCase {
    override suspend fun invoke(): Flow<ResultData<List<AdviceEntity>>> {
        return flow {
            emit(ResultData.Loading)
            try {
               val advices =  adviceRepository.getFavoriteAdvice().map {
                    it.toDomain()
                }
                emit(ResultData.Success(advices))

            } catch (exception: Exception) {
                emit(ResultData.Failure(exception))
            }
        }
    }
}