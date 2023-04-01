package com.girrafeecstud.onbort.feature_quests.domain

data class Quest(
    val questId: Long = 1,
    val optional: Boolean = false,
    val name: String = "Complete task",
    val descriptions: String = "random description",
    val type: String? = null,
    val articleId: Long? = null,
    val stageCoins: Int? = null
)
