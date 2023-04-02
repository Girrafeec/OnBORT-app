/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.navigation

import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.navigation.destination.NavigationDestination

sealed class QuestFlowDestination(
    private val _destinationId: Int
) : NavigationDestination {

    override val destinationId: Int
        get() = _destinationId

    data class QuestDetails(
        val questId: String? = null
    ) : QuestFlowDestination(_destinationId = R.id.quest_fragment)

    class Stage(
    ) : QuestFlowDestination(_destinationId = R.id.stage_fragment)

}