/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.data.datasource

import com.girrafeecstud.core_base.base.ExceptionType
import com.girrafeecstud.core_base.base.NoNetworkConnectionException
import com.girrafeecstud.core_base.domain.base.BusinessErrorType
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_auth.login.data.network.api.LoginApi
import com.girrafeecstud.onbort.feature_auth.login.data.network.mapper.LoginEntityDtoMapper
import com.girrafeecstud.onbort.feature_auth.login.domain.UserLoginEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class LoginDataSource @Inject constructor(
    private val requestMapper: LoginEntityDtoMapper,
    private val api: LoginApi
) : ILoginDataSource {

    override fun login(user: UserLoginEntity): Flow<BusinessResult<String>> =
        flow {
            val loginRequestDto = requestMapper.map(input = user)

            try {

                val response = api.login(loginRequest = loginRequestDto)
                val responseBody = response.body()

                if (response.isSuccessful && responseBody != null) {
                    emit(BusinessResult.Success(data = responseBody))
                } else {
                    emit(BusinessResult.Error(businessErrorType = BusinessErrorType.WRONG_LOGIN_DATA))
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