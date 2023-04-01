/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.girrafeecstud.onbort.feature_articles.presentation.ArticleDetailsViewModel

@Composable
fun ArticleScreen(
    articleId: Long,
    articleDetailsViewModel: ArticleDetailsViewModel = hiltViewModel()
) {
    articleDetailsViewModel.articleId = articleId
    articleDetailsViewModel.getArticleDetails()
}