package com.girrafeecstud.onbort.feature_quests.data

import com.girrafeecstud.core_base.domain.base.BusinessErrorType
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_auth.common.datasource.IAuthDataSource
import com.girrafeecstud.onbort.feature_quests.domain.IQuestsRepository
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.domain.Stage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class QuestRepository @Inject constructor(
    private val questsDataSource: QuestsDataSource,
    private val authDataSource:IAuthDataSource
) : IQuestsRepository {
    override suspend fun getQuestList(): Flow<BusinessResult<List<Quest>>> =
        authDataSource.getUserToken().flatMapLatest { authResult ->
            when (authResult) {
                is BusinessResult.Success -> {
                    val token = authResult.data
                    if (token != null)
                        questsDataSource.getQuests(token = token)
                    else
                        flowOf(BusinessResult.Error(businessErrorType = BusinessErrorType.USER_UNAUTHORIZED))
                }
                is BusinessResult.Error -> flowOf(authResult)
                is BusinessResult.Exception -> flowOf(authResult)
            }
        }

    override suspend fun getQuest(questId: Long): Flow<BusinessResult<Quest>> =
        authDataSource.getUserToken().flatMapLatest { authResult ->
            when (authResult) {
                is BusinessResult.Success -> {
                    val token = authResult.data
                    if (token != null)
                        questsDataSource.getQuest(token = token, questId = questId)
                    else
                        flowOf(BusinessResult.Error(businessErrorType = BusinessErrorType.USER_UNAUTHORIZED))
                }
                is BusinessResult.Error -> flowOf(authResult)
                is BusinessResult.Exception -> flowOf(authResult)
            }
        }

    override suspend fun getQuestStage(questId: Long, stageId: Long): Flow<BusinessResult<Stage>> =
        authDataSource.getUserToken().flatMapLatest { authResult ->
            when (authResult) {
                is BusinessResult.Success -> {
                    val token = authResult.data
                    if (token != null)
                        questsDataSource.getStage(
                            token = token,
                            questId = questId,
                            stageId = stageId
                        )
                    else
                        flowOf(BusinessResult.Error(businessErrorType = BusinessErrorType.USER_UNAUTHORIZED))
                }
                is BusinessResult.Error -> flowOf(authResult)
                is BusinessResult.Exception -> flowOf(authResult)
            }
        }

    override suspend fun applyStage(
        questId: Long,
        stageId: Long
    ): Flow<BusinessResult<StagePassedResponseDto>> =
        authDataSource.getUserToken().flatMapLatest { authResult ->
            when (authResult) {
                is BusinessResult.Success -> {
                    val token = authResult.data
                    if (token != null)
                        questsDataSource.applyStage(
                            token = token,
                            questId = questId,
                            stageId = stageId
                        )
                    else
                        flowOf(BusinessResult.Error(businessErrorType = BusinessErrorType.USER_UNAUTHORIZED))
                }
                is BusinessResult.Error -> flowOf(authResult)
                is BusinessResult.Exception -> flowOf(authResult)
            }
        }
}