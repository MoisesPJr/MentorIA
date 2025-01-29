package com.example.mentoria.randomAdviceFeature.data.repository

import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.example.mentoria.randomAdviceFeature.data.model.SlipRemote
import com.example.mentoria.randomAdviceFeature.domain.repository.AdviceRepository
import com.example.mentoria.randomAdviceFeature.domain.source.AdviceDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AdviceRepositoryImpl @Inject constructor(
    private val dataSource: AdviceDataSource
): AdviceRepository {
    override suspend fun getAdvice(): Flow<AdviceRemote> {
        return flow {
            emit(dataSource.getAdvice())
        }
    }
}