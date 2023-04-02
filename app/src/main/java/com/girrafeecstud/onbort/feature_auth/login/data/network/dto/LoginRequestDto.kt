/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.data.network.dto

import com.google.gson.annotations.SerializedName


data class LoginRequestDto(

    @SerializedName("email")
    val userEmail: String,
    @SerializedName("password")
    val userPassword: String,

)