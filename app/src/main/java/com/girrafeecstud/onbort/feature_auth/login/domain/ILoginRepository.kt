/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.core_base.domain.base.EmptyResult
import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    fun login(user: UserLoginEntity): Flow<BusinessResult<EmptyResult>>
}