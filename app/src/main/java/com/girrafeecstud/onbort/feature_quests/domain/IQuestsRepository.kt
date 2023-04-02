package com.girrafeecstud.onbort.feature_quests.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_quests.data.StagePassedResponseDto
import kotlinx.coroutines.flow.Flow

interface IQuestsRepository {
    suspend fun getQuestList(): Flow<BusinessResult<List<Quest>>>
    suspend fun getQuest(questId: Long): Flow<BusinessResult<Quest>>
    suspend fun getQuestStage(questId: Long, stageId: Long): Flow<BusinessResult<Stage>>
    suspend fun applyStage(questId: Long, stageId: Long): Flow<BusinessResult<StagePassedResponseDto>>
}