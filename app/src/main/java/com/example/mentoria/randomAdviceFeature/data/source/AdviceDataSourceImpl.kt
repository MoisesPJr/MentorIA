package com.example.mentoria.randomAdviceFeature.data.source

import com.example.mentoria.favoriteAdvice.data.db.AdviceDao
import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.example.mentoria.randomAdviceFeature.data.model.SlipRemote
import com.example.mentoria.randomAdviceFeature.data.service.AdviceApi
import com.example.mentoria.randomAdviceFeature.domain.model.Slip
import com.example.mentoria.randomAdviceFeature.domain.source.AdviceDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AdviceDataSourceImpl @Inject constructor(
    private val adviceApi: AdviceApi
) : AdviceDataSource {
    override suspend fun getAdvice(): AdviceRemote {
       return adviceApi.getAdvice()
    }



}