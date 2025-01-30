package com.mjtech.mentoria.favoriteAdvice.di

import android.content.Context
import androidx.room.Room
import com.mjtech.mentoria.favoriteAdvice.data.db.AdviceDao
import com.mjtech.mentoria.favoriteAdvice.data.db.AdviceDb
import com.mjtech.mentoria.favoriteAdvice.data.repository.FavoriteAdviceRepositoryImpl
import com.mjtech.mentoria.favoriteAdvice.data.source.FavoriteAdviceDataSourceImpl
import com.mjtech.mentoria.favoriteAdvice.domain.repository.FavoriteAdviceRepository
import com.mjtech.mentoria.favoriteAdvice.domain.source.FavoriteAdviceDataSource
import com.mjtech.mentoria.favoriteAdvice.domain.useCase.DeleteFavoriteAdviceUseCase
import com.mjtech.mentoria.favoriteAdvice.domain.useCase.DeleteFavoriteAdviceUseCaseImpl
import com.mjtech.mentoria.favoriteAdvice.domain.useCase.GetFavoriteAdviceUseCase
import com.mjtech.mentoria.favoriteAdvice.domain.useCase.GetFavoriteAdviceUseCaseImpl
import com.mjtech.mentoria.favoriteAdvice.domain.useCase.SetFavoriteAdviceUseCase
import com.mjtech.mentoria.favoriteAdvice.domain.useCase.SetFavoriteAdviceUseCaseImpl
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