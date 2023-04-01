/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.network.dto

import com.google.gson.annotations.SerializedName

data class ChapterDto(
    @SerializedName("articleId")
    val articleId: Long,
    @SerializedName("chapterId")
    val chapterId: Long,
    @SerializedName("chapterName")
    val chapterName: String,
    @SerializedName("chapterText")
    val chapterText: String,
    @SerializedName("chapterImageUrl")
    val chapterImageUrl: String? = null,
    @SerializedName("extraMediaSourceUrl")
    val extraMediaSourceUrl: String? = null
)