/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.presentation

import com.girrafeecstud.core_ui.presentation.UiState
import com.girrafeecstud.onbort.feature_articles.domain.Article

data class ArticleDetailsUiState(
    val isLoading: Boolean = false,
    val article: Article? = null,
    val error: String? = null
) : UiState