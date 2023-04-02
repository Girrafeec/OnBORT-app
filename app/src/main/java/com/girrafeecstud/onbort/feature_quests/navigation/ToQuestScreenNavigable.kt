/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.navigation

import com.girrafeecstud.onbort.navigation.ToScreenNavigable

interface ToQuestScreenNavigable : ToScreenNavigable<QuestFlowDestination> {
    override fun navigateToScreen(destination: QuestFlowDestination)
}