/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.data

import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.domain.Stage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface QuestsApi {

    @GET("quests")
    fun getQuests(@Header("Authorization") token: String): Response<List<Quest>>

    @GET("quests/{id}")
    fun getQuest(@Header("Authorization") token: String, @Path("id") questId: Long): Response<Quest>

    @GET("quests/{questId}/stages/{stageId}")
    fun getStage(
        @Header("Authorization") token: String,
        @Path("questId") questId: Long,
        @Path("stageId") stageId: Long
    ): Response<Stage>

    @POST("quests/{questId}/stages/{stageId}")
    fun applyStage(
        @Header("Authorization") token: String,
        @Path("questId") questId: Long,
        @Path("stageId") stageId: Long
    ): Response<StagePassedResponseDto>

}