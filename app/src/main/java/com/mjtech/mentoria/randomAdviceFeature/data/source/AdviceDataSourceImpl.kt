package com.mjtech.mentoria.randomAdviceFeature.data.source

import com.mjtech.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.mjtech.mentoria.randomAdviceFeature.data.service.AdviceApi
import com.mjtech.mentoria.randomAdviceFeature.domain.source.AdviceDataSource
import javax.inject.Inject

class AdviceDataSourceImpl @Inject constructor(
    private val adviceApi: AdviceApi
) : AdviceDataSource {
    override suspend fun getAdvice(): AdviceRemote {
       return adviceApi.getAdvice()
    }



}