/* Created by Girrafeec */

package com.girrafeecstud.onbort.navigation

import android.os.Bundle
import androidx.navigation.NavController
import com.girrafeecstud.onbort.navigation.destination.FlowDestination
import com.girrafeecstud.onbort.navigation.destination.NavigationDestination

fun NavController.setStartDestination(
    destination: NavigationDestination,
    graphId: Int
) {
    val graph = this.navInflater.inflate(graphId)
    graph.setStartDestination(destination.destinationId)
    // Add start destination args (default screen value)
    var bundle: Bundle? = null
    if (destination is FlowDestination) {
        bundle = Bundle()
        bundle.putSerializable("defaultScreen", destination.defaultScreen)
    }
    this.setGraph(graph = graph, startDestinationArgs = bundle)
}