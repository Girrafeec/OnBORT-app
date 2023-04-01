package com.girrafeecstud.onbort.feature_quests.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import kotlinx.coroutines.flow.Flow

interface IQuestsRepository {
    suspend fun getQuestList(): Flow<BusinessResult<List<Quest>>>
    suspend fun getQuest(questId: Long): Flow<BusinessResult<Quest>>
    suspend fun getQuestStageList(): Flow<BusinessResult<List<Stage>>>
    suspend fun getQuestStage(): Flow<BusinessResult<Stage>>
}