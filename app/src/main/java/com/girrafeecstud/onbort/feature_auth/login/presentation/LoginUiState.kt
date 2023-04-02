/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.presentation

import com.girrafeecstud.core_ui.presentation.UiState

data class LoginUiState(
    val isLoading: Boolean = false,
    val loginPassed: Boolean? = null
) : UiState