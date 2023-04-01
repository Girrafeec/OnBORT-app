/* Created by Girrafeec */

package com.girrafeecstud.onbort.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.girrafeecstud.core_ui.ui.theme.UnscrambleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnscrambleTheme {
                //TODO check if user if authorized and set as start destination login screen or home screen
            }
        }
    }
}