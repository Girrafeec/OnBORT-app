/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth

import com.girrafeecstud.core_ui.ui.BaseFlowFragment
import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.navigation.FlowNavigator
import com.girrafeecstud.onbort.navigation.destination.FlowDestination

class AuthFlowFragment : BaseFlowFragment(
    R.id.nav_host_fragment_auth_container
) {

    fun navigateToMainFlow() {
        (requireActivity() as FlowNavigator).navigateToDestination(
            destination = FlowDestination.QuestFlow()
        )
    }

}