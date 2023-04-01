/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.common.repository

import com.girrafeecstud.onbort.feature_auth.common.datasource.IAuthDataSource
import com.girrafeecstud.core_base.domain.base.BusinessResult
import javax.inject.Inject

class IAuthSharedPreferencesRepository @Inject constructor(
    private val authDataSource: IAuthDataSource
) : IAuthRepository {

    override suspend fun getUserAuthorizedStatus(): Boolean =
        authDataSource.getUserAuthorizedStatus()

    override suspend fun setUserAuthorized() =
        authDataSource.setUserAuthorized()

    override suspend fun setUserUnauthorized() =
        authDataSource.setUserUnauthorized()

    override suspend fun getUserToken(): BusinessResult<String> =
        authDataSource.getUserToken()

    override suspend fun setUserToken(userToken: String) =
        authDataSource.setUserToken(userToken = userToken)

    override suspend fun clearUserToken() =
        authDataSource.clearUserToken()
}