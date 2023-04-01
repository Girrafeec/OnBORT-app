package com.girrafeecstud.onbort.feature_articles.presentation

import com.girrafeecstud.core_ui.presentation.UiState
import com.girrafeecstud.onbort.feature_articles.domain.Article

data class ArticlesUiState(
    val isLoading: Boolean = false,
    val articles: List<Article>? = null,
    val error: String? = null
) : UiState
