/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.di

import com.girrafeecstud.onbort.feature_auth.login.data.datasource.ILoginDataSource
import com.girrafeecstud.onbort.feature_auth.login.data.datasource.LoginDataSource
import com.girrafeecstud.onbort.feature_auth.login.data.network.api.LoginApi
import com.girrafeecstud.onbort.feature_auth.login.data.network.mapper.LoginEntityDtoMapper
import com.girrafeecstud.onbort.feature_auth.login.data.repository.LoginRepository
import com.girrafeecstud.onbort.feature_auth.login.domain.ILoginRepository
import com.girrafeecstud.onbort.feature_auth.login.domain.LoginUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module(includes = [LoginModule.LoginBindModule::class])
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Provides
    fun provideLoginApi(retrofit: Retrofit): LoginApi =
        retrofit.create(LoginApi::class.java)

    @Provides
    fun provideLoginEntityDtoMapper(): LoginEntityDtoMapper =
        LoginEntityDtoMapper()

    @Provides
    fun provideLoginUseCase(repository: ILoginRepository): LoginUseCase =
        LoginUseCase(repository = repository)

    @Module
    @InstallIn(SingletonComponent::class)
    interface LoginBindModule {

        @Binds
        fun bindLoginDataSource(impl: LoginDataSource): ILoginDataSource

        @Binds
        fun bindLoginRepository(impl: LoginRepository): ILoginRepository

    }

}