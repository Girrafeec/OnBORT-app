package com.girrafeecstud.onbort.feature_challenges.domain.entity

import com.google.gson.annotations.SerializedName

data class Challenge(
    @SerializedName("challengeId")
    val challengeId: Long,
    @SerializedName("questions")
    val questions: List<Question>,
    @SerializedName("passToPercent")
    val passToPercent: Double,
    @SerializedName("coins")
    val coins: Int
)
