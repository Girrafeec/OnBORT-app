/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.data

import com.girrafeecstud.core_base.base.ExceptionType
import com.girrafeecstud.core_base.base.NoNetworkConnectionException
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.domain.Stage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class QuestsDataSource @Inject constructor(
    private val api: QuestsApi
) {

    fun getQuests(token: String): Flow<BusinessResult<List<Quest>>> =
        flow {
            try {

                val response = api.getQuests(token = token)
                val responseBody = response.body()

                if (response.isSuccessful && responseBody != null) {
                    val quests = responseBody
                    emit(BusinessResult.Success(data = quests))
                }

            } catch (exception: NoNetworkConnectionException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.NO_INTERNET_CONNECTION))
            } catch (exception: SocketTimeoutException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }catch (exception: IOException) {
                exception.printStackTrace()
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }
        }.flowOn(Dispatchers.IO)

    fun getQuest(questId: Long, token: String): Flow<BusinessResult<Quest>> =
        flow {
            try {

                val response = api.getQuest(token = token, questId = questId)
                val responseBody = response.body()

                if (response.isSuccessful && responseBody != null) {
                    val quests = responseBody
                    emit(BusinessResult.Success(data = quests))
                }

            } catch (exception: NoNetworkConnectionException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.NO_INTERNET_CONNECTION))
            } catch (exception: SocketTimeoutException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }catch (exception: IOException) {
                exception.printStackTrace()
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }
        }.flowOn(Dispatchers.IO)

    fun getStage(questId: Long, stageId: Long, token: String): Flow<BusinessResult<Stage>> =
        flow {
            try {

                val response = api.getStage(token = token, questId = questId, stageId)
                val responseBody = response.body()

                if (response.isSuccessful && responseBody != null) {
                    val quests = responseBody
                    emit(BusinessResult.Success(data = quests))
                }

            } catch (exception: NoNetworkConnectionException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.NO_INTERNET_CONNECTION))
            } catch (exception: SocketTimeoutException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }catch (exception: IOException) {
                exception.printStackTrace()
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }
        }.flowOn(Dispatchers.IO)

    fun applyStage(questId: Long, stageId: Long, token: String): Flow<BusinessResult<StagePassedResponseDto>> =
        flow {
            try {

                val response = api.applyStage(token = token, questId = questId, stageId)
                val responseBody = response.body()

                if (response.isSuccessful && responseBody != null) {
                    val quests = responseBody
                    emit(BusinessResult.Success(data = quests))
                }

            } catch (exception: NoNetworkConnectionException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.NO_INTERNET_CONNECTION))
            } catch (exception: SocketTimeoutException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }catch (exception: IOException) {
                exception.printStackTrace()
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }
        }.flowOn(Dispatchers.IO)

}