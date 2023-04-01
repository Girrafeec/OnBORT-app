/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.common.datasource

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.girrafeecstud.core_base.domain.base.BusinessErrorType
import com.girrafeecstud.core_base.domain.base.BusinessResult
import javax.inject.Inject

class AuthSharedPreferencesDataSource @Inject constructor(
    private val applicationContext: Context
) : IAuthDataSource {

    private var _sharedPreferences: SharedPreferences? = null

    private val sharedPreferences get () = _sharedPreferences!!

    companion object {
        private const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        private const val USER_AUTHORIZED = "USER_AUTHORIZED"
        private const val USER_TOKEN = "USER_TOKEN"
    }

    init {
        _sharedPreferences = applicationContext.getSharedPreferences(
            SHARED_PREFERENCES,
            AppCompatActivity.MODE_PRIVATE
        )
    }

    override suspend fun getUserAuthorizedStatus(): Boolean =
        sharedPreferences.getBoolean(USER_AUTHORIZED, false)

    override suspend fun setUserAuthorized() =
        sharedPreferences
            .edit()
            .putBoolean(USER_AUTHORIZED, true)
            .apply()

    override suspend fun setUserUnauthorized() =
        sharedPreferences
            .edit()
            .putBoolean(USER_AUTHORIZED, false)
            .apply()

    override suspend fun getUserToken(): BusinessResult<String> {
        val result = sharedPreferences
            .getString(USER_TOKEN, null)

        if (result.equals(null))
            return BusinessResult.Error(businessErrorType = BusinessErrorType.USER_UNAUTHORIZED)
        return BusinessResult.Success(data = result)
    }

    override suspend fun setUserToken(userToken: String) =
        sharedPreferences
            .edit()
            .putString(USER_TOKEN, userToken)
            .apply()

    override suspend fun clearUserToken() =
        sharedPreferences
            .edit()
            .putString(USER_TOKEN, null)
            .apply()
}