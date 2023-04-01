/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.common.repository

import com.girrafeecstud.core_base.domain.base.BusinessResult

interface IAuthRepository {

    suspend fun getUserAuthorizedStatus(): Boolean

    suspend fun setUserAuthorized()

    suspend fun setUserUnauthorized()

    suspend fun getUserToken(): BusinessResult<String>

    suspend fun setUserToken(userToken: String)

    suspend fun clearUserToken()

}