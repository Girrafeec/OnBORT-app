/* Created by Girrafeec */

package com.girrafeecstud.onbort.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.girrafeecstud.core_ui.ui.theme.UnscrambleTheme
import com.girrafeecstud.onbort.feature_quests.UI.QuestDetailsScreen
import com.girrafeecstud.onbort.feature_quests.UI.QuestsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnscrambleTheme {
                QuestDetailsScreen(4)
            }
        }
    }
}