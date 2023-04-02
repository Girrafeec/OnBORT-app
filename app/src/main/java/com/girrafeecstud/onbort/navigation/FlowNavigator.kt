/* Created by Girrafeec */

package com.girrafeecstud.onbort.navigation

import android.util.Log
import androidx.navigation.NavController
//import com.girrafeecstud.onbort.MainNavFlowDirections
import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.navigation.destination.FlowDestination

class FlowNavigator : Navigator<FlowDestination> {

    // TODO Inject navController to FlowNavigator
    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun navigateToDestination(destination: FlowDestination) {
//        when (destination) {
//            is FlowDestination.AuthFlow -> {
//                navController?.navigate(
//                    MainNavFlowDirections.actionGlobalAuthFlow()
//                )
//            }
//            is FlowDestination.MapsFlow -> {
//                navController?.navigate(
//                    MainNavFlowDirections
//                        .actionGlobalMainFlow()
//                        .setDefaultScreen(destination.defaultScreen as DefaultMainFlowScreen)
//                )
//            }
//            is FlowDestination.QuestFlow -> {
//                navController?.navigate(
//                    MainNavFlowDirections
//                        .actionGlobalQuestFlow()
//                        .setDefaultScreen(destination.defaultScreen as DefaultQuestFlowScreen)
//                )
//            }
//        }
        Log.i("navigation", "backstack")
        for (entry in navController?.backQueue!!)
            Log.i("navigation entry", entry.destination.toString())
    }

    override fun setStartDestination(destination: FlowDestination) {
        navController?.setStartDestination(
            destination = destination, graphId = R.navigation.main_nav_flow
        )
        Log.i("navigation", "backstack")
        for (entry in navController?.backQueue!!)
            Log.i("navigation entry", entry.destination.toString())
    }

}