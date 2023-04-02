/* Created by Girrafeec */

package com.girrafeecstud.onbort.app.navigation

import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.navigation.destination.NavigationDestination

sealed class MainFlowDestination(
    private val _destinationId: Int
) : NavigationDestination {

    override val destinationId: Int
        get() = _destinationId

    class HomeFragment(
    ) : MainFlowDestination(_destinationId = R.id.home_fragment)

    class QuestsFragment(
    ) : MainFlowDestination(_destinationId = R.id.quests_fragment)

    class ExtrasFragment(
    ) : MainFlowDestination(_destinationId = R.id.extras_fragment)

    class ProfileFragment(
    ) : MainFlowDestination(_destinationId = R.id.profile_fragment)

}