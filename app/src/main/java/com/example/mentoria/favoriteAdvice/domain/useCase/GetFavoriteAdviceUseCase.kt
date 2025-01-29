package com.example.mentoria.favoriteAdvice.domain.useCase

import com.example.mentoria.core.utils.ResultData
import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.favoriteAdvice.domain.mapper.toDomain
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