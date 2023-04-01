package com.girrafeecstud.onbort.feature_challenges.domain.entity

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("challengeId")
    val challengeId: Long,
    @SerializedName("questionId")
    val questionId: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("answers")
    val answers: List<String>
)
