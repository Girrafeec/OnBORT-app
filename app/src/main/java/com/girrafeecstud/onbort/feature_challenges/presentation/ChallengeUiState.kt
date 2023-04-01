/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_challenges.presentation

import com.girrafeecstud.core_ui.presentation.UiState
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Challenge
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Submission

data class ChallengeUiState(
    val isLoading: Boolean = false,
    val challenge: Challenge? = null,
    val error: String? = null,
    val submission: Submission? = null
) : UiState