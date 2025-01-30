package com.mjtech.mentoria.randomAdviceFeature.di

import com.mjtech.mentoria.randomAdviceFeature.data.service.AdviceApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.adviceslip.com/"


    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Provides
    @Singleton
    fun providesRetrofitAdvice(): Retrofit {
        val okHttpClient: OkHttpClient.Builder = OkHttpClient().newBuilder()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun provideAdviceApi(retrofit: Retrofit): AdviceApi {
        return retrofit.create(AdviceApi::class.java)
    }

}