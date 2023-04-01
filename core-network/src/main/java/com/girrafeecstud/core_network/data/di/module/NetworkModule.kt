/* Created by Girrafeec */

package com.girrafeecstud.core_network.data.di.module

import com.girrafeecstud.core_network.data.di.annotation.BaseApiUrl
import com.girrafeecstud.core_network.data.network.NetworkConnectionInterceptor
import com.girrafeecstud.core_network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @BaseApiUrl
    fun provideBaseApiUrl() = BuildConfig.API_BASE_URL

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideScalarsConverterFactory(): ScalarsConverterFactory = ScalarsConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        networkConnectionInterceptor: NetworkConnectionInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(networkConnectionInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        scalarsConverterFactory: ScalarsConverterFactory,
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient,
        @BaseApiUrl baseApiUrl: String
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseApiUrl)
            .addConverterFactory(scalarsConverterFactory)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()

}