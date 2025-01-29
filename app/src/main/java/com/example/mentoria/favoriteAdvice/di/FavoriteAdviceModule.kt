package com.example.mentoria.favoriteAdvice.di

import android.content.Context
import androidx.room.Room
import com.example.mentoria.favoriteAdvice.data.db.AdviceDao
import com.example.mentoria.favoriteAdvice.data.db.AdviceDb
import com.example.mentoria.favoriteAdvice.data.repository.FavoriteAdviceRepositoryImpl
import com.example.mentoria.favoriteAdvice.data.source.FavoriteAdviceDataSourceImpl
import com.example.mentoria.favoriteAdvice.domain.repository.FavoriteAdviceRepository
import com.example.mentoria.favoriteAdvice.domain.source.FavoriteAdviceDataSource
import com.example.mentoria.favoriteAdvice.domain.useCase.DeleteFavoriteAdviceUseCase
import com.example.mentoria.favoriteAdvice.domain.useCase.DeleteFavoriteAdviceUseCaseImpl
import com.example.mentoria.favoriteAdvice.domain.useCase.GetFavoriteAdviceUseCase
import com.example.mentoria.favoriteAdvice.domain.useCase.GetFavoriteAdviceUseCaseImpl
import com.example.mentoria.favoriteAdvice.domain.useCase.SetFavoriteAdviceUseCase
import com.example.mentoria.favoriteAdvice.domain.useCase.SetFavoriteAdviceUseCaseImpl
import com.example.mentoria.randomAdviceFeature.data.repository.AdviceRepositoryImpl
import com.example.mentoria.randomAdviceFeature.data.service.AdviceApi
import com.example.mentoria.randomAdviceFeature.data.source.AdviceDataSourceImpl
import com.example.mentoria.randomAdviceFeature.domain.repository.AdviceRepository
import com.example.mentoria.randomAdviceFeature.domain.source.AdviceDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FavoriteAdviceModule {

    @Provides
    @Singleton
    fun provideFavoriteAdviceDataSource(dao: AdviceDao): FavoriteAdviceDataSource {
        return FavoriteAdviceDataSourceImpl(dao)
    }

    @Provides
    @Singleton
    fun provideFavoriteAdviceRepository(dataSource: FavoriteAdviceDataSource): FavoriteAdviceRepository {
        return FavoriteAdviceRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideSetFavoriteAdviceUseCase(adviceRepository: FavoriteAdviceRepository): SetFavoriteAdviceUseCase{
        return SetFavoriteAdviceUseCaseImpl(adviceRepository)
    }

    @Provides
    @Singleton
    fun provideGetFavoriteAdviceUseCase(adviceRepository: FavoriteAdviceRepository): GetFavoriteAdviceUseCase {
        return GetFavoriteAdviceUseCaseImpl(adviceRepository)
    }


    @Provides
    @Singleton
    fun provideDeleteFavoriteAdviceUseCase(adviceRepository: FavoriteAdviceRepository): DeleteFavoriteAdviceUseCase {
        return DeleteFavoriteAdviceUseCaseImpl(adviceRepository)
    }


    @Singleton
    @Provides
    fun provideAdviceDb(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AdviceDb::class.java,
        "AdviceDb"
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideYourDao(db: AdviceDb) = db.getDao()

}