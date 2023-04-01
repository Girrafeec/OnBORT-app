package com.girrafeecstud.onbort.feature_quests.domain

data class Stage(
    val idQuest: Long,
    val stageQuestId: Long,
    val name: String,
    val description: String,
    val type: String,
    val article_id: Long,
    val stageCoins: Int
)
