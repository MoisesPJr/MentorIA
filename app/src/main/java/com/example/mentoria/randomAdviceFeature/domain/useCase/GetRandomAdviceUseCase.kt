package com.example.mentoria.randomAdviceFeature.domain.useCase

import com.example.mentoria.core.utils.ResultData
import com.example.mentoria.randomAdviceFeature.domain.mapper.toDomain
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.repository.AdviceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetRandomAdviceUseCase {
    suspend operator fun invoke():Flow<Advice>
}

class GetRandomAdviceUseCaseImpl @Inject constructor(
private val adviceRepository: AdviceRepository
): GetRandomAdviceUseCase {
    override suspend fun invoke():Flow<Advice> {
        return adviceRepository.getAdvice()
            .map { it.toDomain() }
    }


}