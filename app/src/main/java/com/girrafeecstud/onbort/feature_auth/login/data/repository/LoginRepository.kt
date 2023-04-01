/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.data.repository

import com.girrafeecstud.onbort.feature_auth.common.datasource.IAuthDataSource
import com.girrafeecstud.onbort.feature_auth.login.data.datasource.ILoginDataSource
import com.girrafeecstud.onbort.feature_auth.login.domain.ILoginRepository
import com.girrafeecstud.onbort.feature_auth.login.domain.UserLoginEntity
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.core_base.domain.base.EmptyResult
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginDataSource: ILoginDataSource,
    private val authDataSource: IAuthDataSource
) : ILoginRepository {

    private val loginRepositoryScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun login(user: UserLoginEntity): Flow<BusinessResult<EmptyResult>> =
        loginDataSource.login(user = user).flatMapLatest { loginResult ->
            when (loginResult) {
                is BusinessResult.Success -> {
                    loginRepositoryScope.async {
                        authDataSource.setUserAuthorized()
                    }
                    loginRepositoryScope.async {
                        authDataSource.setUserToken(userToken = loginResult.data!!)
                    }.await()
                    flowOf(BusinessResult.Success(EmptyResult))
                }
                is BusinessResult.Error -> flowOf(loginResult)
                is BusinessResult.Exception -> flowOf(loginResult)
            }
        }
}