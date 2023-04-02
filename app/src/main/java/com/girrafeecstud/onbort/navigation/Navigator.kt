/* Created by Girrafeec */

package com.girrafeecstud.onbort.navigation

interface Navigator<in NavigationDestination> {

    fun navigateToDestination(destination: NavigationDestination)

    fun setStartDestination(
        destination: NavigationDestination,
        serializableArgs: Map<String, java.io.Serializable>? = null,
        stringArgs: Map<String, String>? = null
    )

}