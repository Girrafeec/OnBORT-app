package com.girrafeecstud.onbort.feature_quests.data

import com.google.gson.annotations.SerializedName

data class StagePassedResponseDto(
    @SerializedName("passed")
    val passed: Boolean
)
