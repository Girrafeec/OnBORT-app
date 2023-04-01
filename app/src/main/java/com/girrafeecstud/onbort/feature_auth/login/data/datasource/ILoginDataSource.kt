/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.data.datasource

import com.girrafeecstud.onbort.feature_auth.login.domain.UserLoginEntity
import com.girrafeecstud.core_base.domain.base.BusinessResult
import kotlinx.coroutines.flow.Flow

interface ILoginDataSource {

    fun login(user: UserLoginEntity): Flow<BusinessResult<String>>

}