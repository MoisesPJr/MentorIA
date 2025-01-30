package com.mjtech.mentoria.randomAdviceFeature.di

import com.mjtech.mentoria.randomAdviceFeature.data.repository.AdviceRepositoryImpl
import com.mjtech.mentoria.randomAdviceFeature.data.service.AdviceApi
import com.mjtech.mentoria.randomAdviceFeature.data.source.AdviceDataSourceImpl
import com.mjtech.mentoria.randomAdviceFeature.domain.repository.AdviceRepository
import com.mjtech.mentoria.randomAdviceFeature.domain.source.AdviceDataSource
import com.mjtech.mentoria.randomAdviceFeature.domain.useCase.GetRandomAdviceUseCase
import com.mjtech.mentoria.randomAdviceFeature.domain.useCase.GetRandomAdviceUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AdviceModule {

    @Provides
    @Singleton
    fun providesAdviceDataSource(api: AdviceApi): AdviceDataSource {
        return AdviceDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun providesAdviceRepository(dataSource: AdviceDataSource): AdviceRepository {
        return AdviceRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun providesGetAdviceUseCase(adviceRepository: AdviceRepository): GetRandomAdviceUseCase {
        return GetRandomAdviceUseCaseImpl(adviceRepository)
    }
}