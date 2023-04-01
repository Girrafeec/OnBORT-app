package com.girrafeecstud.onbort.feature_quests.UI

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.presentation.QuestsViewModel

@Composable
fun QuestsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    questsViewModel: QuestsViewModel = hiltViewModel()
) {
    val questsUiState by questsViewModel.state.collectAsState()
    if (questsUiState.questsList != null) {
        ShowQuestsList(questsList = questsUiState.questsList!!)
        Log.d(TAG, "Lists Called")
    }
}

@Composable
fun ShowQuestsList(
    questsList: List<Quest>,
    modifier: Modifier = Modifier) {
    LazyColumn {
         items(questsList) {quest ->
                 QuestCard(quest = quest)
             Log.d(TAG, "Lists Created")

         }
    }

}

@Composable
fun QuestCard(quest: Quest, modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .padding(12.dp)
        .clickable {  },
        elevation = 6.dp) {
        Column {
            Text(text = quest.name)
            Text(text = quest.descriptions)
            
        }
    }

}

