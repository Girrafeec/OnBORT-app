/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.navigation

import androidx.navigation.NavController
import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.navigation.Navigator
import com.girrafeecstud.onbort.navigation.setStartDestination
import java.io.Serializable

class QuestFlowNavigator : Navigator<QuestFlowDestination> {

    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun navigateToDestination(destination: QuestFlowDestination) {
        when (destination) {
            is QuestFlowDestination.QuestDetails -> {
                navController?.navigate(R.id.quest_fragment)
            }
            is QuestFlowDestination.Stage -> {
                navController?.navigate(R.id.stage_fragment)
            }
        }
    }

    override fun setStartDestination(
        destination: QuestFlowDestination,
        serializableArgs: Map<String, Serializable>?,
        stringArgs: Map<String, String>?
    ) {
        navController?.setStartDestination(
            destination = destination,
            graphId = R.navigation.quest_flow,
            serializableArgs = serializableArgs,
            stringArgs = stringArgs
        )
    }

}