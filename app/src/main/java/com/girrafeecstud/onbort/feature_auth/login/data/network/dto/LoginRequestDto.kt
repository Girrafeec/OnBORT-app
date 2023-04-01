/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.data.network.dto

import com.google.gson.annotations.SerializedName


data class LoginRequestDto(

    @SerializedName("userEmail")
    val userEmail: String,
    @SerializedName("userPassword")
    val userPassword: String,

)