package com.girrafeecstud.onbort.feature_quests.domain

import com.google.gson.annotations.SerializedName

data class Stage(
    @SerializedName("questId")
    val idQuest: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("stageId")
    val stageId: Long,
    @SerializedName("stageType")
    val type: String,
    @SerializedName("articleId")
    val articleid: Long?,
    @SerializedName("testId")
    val testid: Long?,
    @SerializedName("roomId")
    val roomid: Long?,
    @SerializedName("passed")
    val passed: Boolean
)
