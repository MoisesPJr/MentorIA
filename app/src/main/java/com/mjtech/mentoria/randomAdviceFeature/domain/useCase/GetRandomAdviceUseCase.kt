package com.mjtech.mentoria.randomAdviceFeature.domain.useCase

import com.mjtech.mentoria.core.utils.ResultData
import com.mjtech.mentoria.randomAdviceFeature.domain.mapper.toDomain
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Advice
import com.mjtech.mentoria.randomAdviceFeature.domain.repository.AdviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface GetRandomAdviceUseCase {
    suspend operator fun invoke(): Flow<ResultData<Advice>>
}

class GetRandomAdviceUseCaseImpl @Inject constructor(
    private val adviceRepository: AdviceRepository
) : GetRandomAdviceUseCase {
    override suspend fun invoke(): Flow<ResultData<Advice>> {
        return flow {
            try {
                emit(ResultData.Loading)
                adviceRepository.getAdvice()
                    .map { it.toDomain() }
                    .collect { advice ->
                        emit(ResultData.Success(advice))
                    }
            } catch (exception: IOException) {
                emit(ResultData.Failure(exception))
            } catch (exception: HttpException) {
                emit(ResultData.Failure(exception))
            }
        }
    }
}