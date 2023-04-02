/* Created by Girrafeec */

package com.girrafeecstud.onbort.navigation

import android.os.Bundle
import androidx.navigation.NavController
import com.girrafeecstud.onbort.navigation.destination.FlowDestination
import com.girrafeecstud.onbort.navigation.destination.NavigationDestination

fun NavController.setStartDestination(
    destination: NavigationDestination,
    graphId: Int,
    arg: Any? = null,
    serializableArgs: Map<String, java.io.Serializable>? = null,
    stringArgs: Map<String, String>? = null
) {
    val graph = this.navInflater.inflate(graphId)
    graph.setStartDestination(destination.destinationId)
    // Add start destination args (default screen value)
    var bundle: Bundle? = Bundle()
    if (serializableArgs !=  null)
        for (arg in serializableArgs)
            bundle?.putSerializable(arg.key, arg.value)
    if (stringArgs != null)
        for (arg in stringArgs)
            bundle?.putSerializable(arg.key, arg.value)
    if (destination is FlowDestination) {
        bundle?.putSerializable("defaultScreen", destination.defaultScreen)
    }
    this.setGraph(graph = graph, startDestinationArgs = bundle)
}