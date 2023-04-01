package com.girrafeecstud.onbort.feature_quests.presentation
import com.girrafeecstud.core_ui.presentation.UiState
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class QuestsUiState(
    val isLoading: Boolean = false,
    val questsList: List<Quest>? = null,
    val onError: String? = null
) : UiState