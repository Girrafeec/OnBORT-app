package com.girrafeecstud.onbort.feature_quests.UI

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.presentation.QuestDetailsViewModel

@Composable
fun QuestDetailsScreen(
    questId: Long,
    modifier: Modifier = Modifier,
    questViewModel: QuestDetailsViewModel = hiltViewModel()
) {
    questViewModel.getQuestDetails(questId)
    val questDetailUiState by questViewModel.state.collectAsState()
    if (questDetailUiState.quest != null) {
        ShowQuest(quest = questDetailUiState.quest!!)
    }
}
@Composable
fun ShowQuest(quest: Quest) {
    Text(text = quest.name,
    fontSize = 16.sp)
}


