/* Created by Girrafeec */

package com.girrafeecstud.onbort.navigation

interface ToScreenNavigable <in NavigationDestination> {
    fun navigateToScreen(destination: NavigationDestination)
}