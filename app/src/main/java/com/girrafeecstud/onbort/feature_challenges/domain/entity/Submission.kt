package com.girrafeecstud.onbort.feature_challenges.domain.entity

import com.google.gson.annotations.SerializedName

data class Submission(
    @SerializedName("challengeId")
    val challengeId: Long,
    @SerializedName("submissionId")
    val submissionId: Long,
    @SerializedName("datetime")
    val dateTime: String,
    @SerializedName("submissionPercent")
    val submissionPercent: Double,
    @SerializedName("challengePassed")
    val challengePassed: Boolean
)
