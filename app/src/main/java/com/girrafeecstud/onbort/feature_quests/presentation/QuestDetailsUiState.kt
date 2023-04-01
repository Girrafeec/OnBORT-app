package com.girrafeecstud.onbort.feature_quests.presentation

import com.girrafeecstud.core_ui.presentation.UiState
import com.girrafeecstud.onbort.feature_quests.domain.Quest

data class QuestDetailsUiState (
    val isLoading: Boolean = false,
    val quest: Quest? = null,
    val onError: String? = null

) : UiState