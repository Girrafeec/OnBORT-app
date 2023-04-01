/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_challenges.di

import com.girrafeecstud.onbort.feature_challenges.data.ChallengeRepository
import com.girrafeecstud.onbort.feature_challenges.domain.ChallengeInteractor
import com.girrafeecstud.onbort.feature_challenges.domain.IChallengeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ChallengeFeatureModule {

    @Provides
    fun provideChallengeInteractor(
        repository: IChallengeRepository
    ): ChallengeInteractor = ChallengeInteractor(repository = repository)

    @Module
    @InstallIn(SingletonComponent::class)
    interface ChallengeFeatureBindModule {

        @Binds
        fun bindChallengeRepository(impl: ChallengeRepository): IChallengeRepository

    }
}