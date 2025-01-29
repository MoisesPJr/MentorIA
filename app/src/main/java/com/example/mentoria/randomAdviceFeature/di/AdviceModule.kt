package com.example.mentoria.randomAdviceFeature.di

import android.content.Context
import androidx.room.Room
import com.example.mentoria.favoriteAdvice.data.db.AdviceDb
import com.example.mentoria.randomAdviceFeature.data.repository.AdviceRepositoryImpl
import com.example.mentoria.randomAdviceFeature.data.service.AdviceApi
import com.example.mentoria.randomAdviceFeature.data.source.AdviceDataSourceImpl
import com.example.mentoria.randomAdviceFeature.domain.repository.AdviceRepository
import com.example.mentoria.randomAdviceFeature.domain.source.AdviceDataSource
import com.example.mentoria.randomAdviceFeature.domain.useCase.GetRandomAdviceUseCase
import com.example.mentoria.randomAdviceFeature.domain.useCase.GetRandomAdviceUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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