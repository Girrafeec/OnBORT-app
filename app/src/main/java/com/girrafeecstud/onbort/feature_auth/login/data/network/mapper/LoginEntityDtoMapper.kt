/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.data.network.mapper

import com.girrafeecstud.core_base.base.Mapper
import com.girrafeecstud.onbort.feature_auth.login.data.network.dto.LoginRequestDto
import com.girrafeecstud.onbort.feature_auth.login.domain.UserLoginEntity

class LoginEntityDtoMapper : Mapper<UserLoginEntity, LoginRequestDto> {

    override fun map(input: UserLoginEntity): LoginRequestDto =
        with(input) {
            LoginRequestDto(
                userEmail = userEmail,
                userPassword = userPassword
            )
        }
}