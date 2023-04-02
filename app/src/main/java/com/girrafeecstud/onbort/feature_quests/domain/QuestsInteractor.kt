package com.girrafeecstud.onbort.feature_quests.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_quests.data.StagePassedResponseDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuestsInteractor @Inject constructor(private val repository: IQuestsRepository) {
    suspend fun getQuestList(): Flow<BusinessResult<List<Quest>>> {
        return repository.getQuestList()
    }
    suspend fun getQuest(questId: Long): Flow<BusinessResult<Quest>> {
        return repository.getQuest(questId)
    }
    suspend fun getQuestStage(questId: Long, stageId: Long): Flow<BusinessResult<Stage>> {
        return repository.getQuestStage(questId, stageId)
    }
    suspend fun applyStage(questId: Long, stageId: Long): Flow<BusinessResult<StagePassedResponseDto>> {
        return repository.applyStage(questId, stageId)
    }
}