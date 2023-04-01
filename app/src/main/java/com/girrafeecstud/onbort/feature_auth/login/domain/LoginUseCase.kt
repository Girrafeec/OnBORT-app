/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.core_base.domain.base.EmptyResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: ILoginRepository
) {

    operator fun invoke(user: UserLoginEntity): Flow<BusinessResult<EmptyResult>> {
        return repository.login(user = user).flowOn(Dispatchers.IO)
    }

}