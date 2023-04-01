package com.girrafeecstud.onbort.feature_quests.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuestRepository @Inject constructor(

) : IQuestsRepository {
    private val quests = listOf(
    Quest(
    questId = 1,
    optional = false,
    name = "Complete task",
    descriptions = "random description",
    type = "type1",
    articleId = 100,
    stageCoins = 5
    ),
    Quest(
    questId = 2,
    optional = true,
    name = "Optional task",
    descriptions = "This task is optional",
    type = "type2",
    articleId = 101,
    stageCoins = 0
    ),
    Quest(
    questId = 3,
    optional = false,
    name = "Find the treasure",
    descriptions = "Discover the hidden treasure",
    type = "type3",
    articleId = 102,
    stageCoins = 10
    ),
    Quest(
    questId = 4,
    optional = true,
    name = "Secret mission",
    descriptions = "Complete the secret mission",
    type = "type4",
    articleId = null,
    stageCoins = 15
    ),
    Quest(
    questId = 5,
    optional = false,
    name = "Boss battle",
    descriptions = "Defeat the boss",
    type = "type5",
    articleId = 103,
    stageCoins = 20
    )
    )
    override suspend fun getQuestList(): Flow<BusinessResult<List<Quest>>> =
        flow {
            emit(BusinessResult.Success(data = quests))
        }

    override suspend fun getQuest(questId: Long): Flow<BusinessResult<Quest>> =
        flow {
            for (quest in quests) {
                if (quest.questId == questId) {
                    emit(BusinessResult.Success(quest))
                }
            }

        }


    override suspend fun getQuestStageList(): Flow<BusinessResult<List<Stage>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestStage(): Flow<BusinessResult<Stage>> {
        TODO("Not yet implemented")
    }

}