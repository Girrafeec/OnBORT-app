/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.data.network.api

import com.girrafeecstud.onbort.feature_auth.login.data.network.config.LoginApiConfig
import com.girrafeecstud.onbort.feature_auth.login.data.network.dto.LoginRequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST(LoginApiConfig.LOGIN_API_PATH)
    suspend fun login(@Body loginRequest: LoginRequestDto): Response<String>

}