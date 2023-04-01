package com.girrafeecstud.onbort.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

enum class NavScreen() {
    ListQuests,
    InfoQuest
}
@Composable
fun NavController(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavScreen.ListQuests.name) {

    }
}


