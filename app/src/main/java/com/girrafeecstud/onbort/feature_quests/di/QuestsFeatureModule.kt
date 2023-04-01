package com.girrafeecstud.onbort.feature_quests.di

import com.girrafeecstud.onbort.feature_quests.domain.IQuestsRepository
import com.girrafeecstud.onbort.feature_quests.domain.QuestRepository
import com.girrafeecstud.onbort.feature_quests.domain.QuestsInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [QuestsFeatureModule.QuestBindModule::class])
@InstallIn(SingletonComponent::class)
class QuestsFeatureModule {
    @Provides
    fun provideQuestInteractor(
        repository: IQuestsRepository
    ): QuestsInteractor = QuestsInteractor(repository)
    @Module
    @InstallIn(SingletonComponent::class)
    interface QuestBindModule {
        @Binds
        fun BindQuestsRepository(impl: QuestRepository): IQuestsRepository
    }

}