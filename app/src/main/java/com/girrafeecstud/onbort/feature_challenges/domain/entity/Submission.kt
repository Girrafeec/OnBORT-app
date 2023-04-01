package com.girrafeecstud.onbort.feature_challenges.domain.entity

import com.google.gson.annotations.SerializedName

data class Submission(
    @SerializedName("challengeId")
    val challengeId: Long,
    @SerializedName("submissionId")
    val submissionId: Long,
    @SerializedName("dateTime")
    val dateTime: String,
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("challengePassed")
    val challengePassed: Boolean
)
