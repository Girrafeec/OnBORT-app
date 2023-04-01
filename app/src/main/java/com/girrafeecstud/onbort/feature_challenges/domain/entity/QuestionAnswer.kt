package com.girrafeecstud.onbort.feature_challenges.domain.entity

import com.google.gson.annotations.SerializedName

data class QuestionAnswer(
    @SerializedName("challengeId")
    val challengeId: Long,
    @SerializedName("questionId")
    val questionId: Long,
    @SerializedName("answerId")
    var answerId: Int? = null
)
