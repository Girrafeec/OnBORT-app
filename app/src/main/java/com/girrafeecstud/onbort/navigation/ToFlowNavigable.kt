/* Created by Girrafeec */

package com.girrafeecstud.onbort.navigation

import com.girrafeecstud.onbort.navigation.destination.FlowDestination

interface ToFlowNavigable : ToScreenNavigable<FlowDestination> {
    override fun navigateToScreen(destination: FlowDestination)
}