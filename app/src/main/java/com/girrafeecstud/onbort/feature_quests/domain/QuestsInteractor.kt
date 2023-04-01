package com.girrafeecstud.onbort.feature_quests.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuestsInteractor @Inject constructor(private val repository: IQuestsRepository) {
    suspend fun getQuestList(): Flow<BusinessResult<List<Quest>>> {
        return repository.getQuestList()
    }
    suspend fun getQuest(questId: Long): Flow<BusinessResult<Quest>> {
        return repository.getQuest(questId)
    }
    suspend fun getQuestStageList(): Flow<BusinessResult<List<Stage>>> {
        return repository.getQuestStageList()
    }
    suspend fun getQuestStage(): Flow<BusinessResult<Stage>> {
        return repository.getQuestStage()
    }
}