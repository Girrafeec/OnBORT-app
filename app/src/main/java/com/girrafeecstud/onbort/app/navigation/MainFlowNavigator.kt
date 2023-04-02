/* Created by Girrafeec */

package com.girrafeecstud.onbort.app.navigation

import androidx.navigation.NavController
import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.navigation.Navigator
import com.girrafeecstud.onbort.navigation.setStartDestination

class MainFlowNavigator : Navigator<MainFlowDestination> {

    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun navigateToDestination(destination: MainFlowDestination) {
//        when (destination) {
//            is MainFlowDestination.ExtrasFragment -> {
//                navController?.navigate(R.id.extras_fragment)
//            }
//            is MainFlowDestination.HomeFragment -> {
//                navController?.navigate(R.id.home_fragment)
//            }
//            is MainFlowDestination.ProfileFragment -> {
//                navController?.navigate(R.id.profile_fragment)
//            }
//            is MainFlowDestination.QuestsFragment -> {
//                navController?.navigate(R.id.quests_fragment)
//            }
//        }
    }

    override fun setStartDestination(
        destination: MainFlowDestination,
        serializableArgs: Map<String, java.io.Serializable>?,
        stringArgs: Map<String, String>?
    ) {
        navController?.setStartDestination(
            destination = destination, graphId = R.navigation.main_flow, serializableArgs = serializableArgs, stringArgs = stringArgs
        )
    }
}