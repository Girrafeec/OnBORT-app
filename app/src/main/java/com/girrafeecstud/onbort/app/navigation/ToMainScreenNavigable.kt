/* Created by Girrafeec */

package com.girrafeecstud.onbort.app.navigation

import com.girrafeecstud.onbort.navigation.ToScreenNavigable

interface ToMainScreenNavigable : ToScreenNavigable<MainFlowDestination> {
    override fun navigateToScreen(destination: MainFlowDestination)
}