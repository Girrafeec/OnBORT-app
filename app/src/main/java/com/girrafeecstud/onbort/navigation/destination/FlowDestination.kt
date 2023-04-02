/* Created by Girrafeec */

package com.girrafeecstud.onbort.navigation.destination

import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.navigation.DefaultFlowScreen
import com.girrafeecstud.onbort.navigation.DefaultMainFlowScreen
import com.girrafeecstud.onbort.navigation.DefaultQuestFlowScreen

sealed class FlowDestination(
    private val _destinationId: Int,
    val defaultScreen: DefaultFlowScreen? = null
) : NavigationDestination {

    override val destinationId: Int
        get() = _destinationId

    class AuthFlow(
    ) : FlowDestination(_destinationId = R.id.auth_flow_fragment)

    class MapsFlow(
        _defaultScreen: DefaultMainFlowScreen =
            DefaultMainFlowScreen.HOME_SCREEN
    ) : FlowDestination(
        _destinationId = R.id.main_flow_fragment,
        defaultScreen = _defaultScreen
    )

    class QuestFlow(
        _defaultScreen: DefaultQuestFlowScreen =
            DefaultQuestFlowScreen.QUEST_DETAILS
    ) : FlowDestination(
        _destinationId = R.id.quest_flow_fragment,
        defaultScreen = _defaultScreen
    )

}