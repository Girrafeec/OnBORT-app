package com.girrafeecstud.onbort.feature_articles.domain

data class Chapter(
    val articleId: Long,
    val chapterId: Long,
    val chapterName: String,
    val chapterText: String,
    val chapterImageUrl: String? = null,
    val extraMediaSourceUrl: String? = null
)
