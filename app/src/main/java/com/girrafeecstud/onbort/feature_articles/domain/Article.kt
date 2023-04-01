package com.girrafeecstud.onbort.feature_articles.domain

data class Article(
    val articleId: Long,
    val articleName: String,
    val articleTitleImageUrl: String? = null,
    val chapters: List<Chapter>? = null
)
