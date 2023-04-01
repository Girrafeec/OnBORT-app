/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.network.dto

import com.girrafeecstud.onbort.feature_articles.domain.Chapter
import com.google.gson.annotations.SerializedName

data class ArticleDto(
    @SerializedName("articleId")
    val articleId: Long,
    @SerializedName("articleName")
    val articleName: String,
    @SerializedName("articleTitleImageUrl")
    val articleTitleImageUrl: String? = null,
    @SerializedName("chapters")
    val chapters: List<ChapterDto>
)