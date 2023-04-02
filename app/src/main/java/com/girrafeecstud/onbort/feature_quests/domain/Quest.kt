package com.girrafeecstud.onbort.feature_quests.domain

import com.google.gson.annotations.SerializedName

data class Quest(
    @SerializedName("questId")
    val questId: Long,
    @SerializedName("optional")
    val optional: Boolean ,
    @SerializedName("passed")
    val passed: Boolean ,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("stages")
    val stages: List<Stage>
)
