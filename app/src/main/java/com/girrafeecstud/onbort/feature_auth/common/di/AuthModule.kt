/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.common.di

import com.girrafeecstud.onbort.feature_auth.common.datasource.AuthSharedPreferencesDataSource
import com.girrafeecstud.onbort.feature_auth.common.datasource.IAuthDataSource
import com.girrafeecstud.onbort.feature_auth.common.repository.IAuthRepository
import com.girrafeecstud.onbort.feature_auth.common.repository.IAuthSharedPreferencesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [AuthModule.AuthBindModule::class])
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface AuthBindModule {

        @Binds
        fun bindAuthSharedPreferencesDataSource(impl: AuthSharedPreferencesDataSource): IAuthDataSource

        @Binds
        fun bindIAuthSharedPreferencesRepository(impl: IAuthSharedPreferencesRepository): IAuthRepository

    }

}