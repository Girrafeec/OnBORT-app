/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.core_base.base.enqueueResponse
import com.girrafeecstud.core_base.domain.base.EmptyResult
import com.girrafeecstud.onbort.feature_auth.AuthTestData
import com.girrafeecstud.onbort.feature_auth.common.datasource.AuthSharedPreferencesDataSource
import com.girrafeecstud.onbort.feature_auth.common.datasource.IAuthDataSource
import com.girrafeecstud.onbort.feature_auth.login.data.datasource.ILoginDataSource
import com.girrafeecstud.onbort.feature_auth.login.data.datasource.LoginDataSource
import com.girrafeecstud.onbort.feature_auth.login.data.network.api.LoginApi
import com.girrafeecstud.onbort.feature_auth.login.data.network.mapper.LoginEntityDtoMapper
import com.girrafeecstud.onbort.feature_auth.login.data.repository.LoginRepository
import com.girrafeecstud.onbort.feature_auth.login.domain.ILoginRepository
import com.github.ivanshafran.sharedpreferencesmock.SPMockBuilder
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class LoginRepositoryUnitTest {

    private lateinit var loginDataSource: ILoginDataSource

    private lateinit var loginApi: LoginApi

    private lateinit var requestMapper: LoginEntityDtoMapper

    private lateinit var loginRepository: ILoginRepository

    private lateinit var authDataSource: IAuthDataSource

    private lateinit var mockWebServer: MockWebServer

    private lateinit var okHttpClient: OkHttpClient

    private lateinit var sharedPreferencesSPMockBuilder: SPMockBuilder

    @Before
    fun setUp() {
        sharedPreferencesSPMockBuilder = SPMockBuilder()
        okHttpClient = OkHttpClient.Builder().build()
        mockWebServer = MockWebServer()
        loginApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(LoginApi::class.java)

        requestMapper = LoginEntityDtoMapper()
        loginDataSource = LoginDataSource(
            api = loginApi,
            requestMapper = requestMapper
        )

        authDataSource = mock()
        loginRepository = LoginRepository(
            loginDataSource = loginDataSource,
            authDataSource = authDataSource
        )

    }

    @Test
    fun `WHEN login is 200 OK EXPECT Bearer token`() =
        runBlocking {
            mockWebServer.enqueueResponse(
                fileName = "TokenResponse",
                code = 200
            )
            val expectedResult = AuthTestData.BEARER_TOKEN

            var actualResult: String? = null

            loginDataSource.login(user = AuthTestData.loginEntity)
                .collect { result ->
                    when(result) {
                        is BusinessResult.Success -> {
                            actualResult = result.data
                        }
                        is BusinessResult.Error -> {}
                        is BusinessResult.Exception -> {}
                    }
                }

            //Request received by the mock server
            mockWebServer.takeRequest()

            assertEquals(expectedResult, actualResult)
        }

    @Test
    fun `WHEN login is 200 OK EXPECT setting token in repository`() =
        runBlocking {
            mockWebServer.enqueueResponse(
                fileName = "TokenResponse",
                code = 200
            )

            loginRepository.login(user = AuthTestData.loginEntity).collect()

            //Request received by the mock server
            mockWebServer.takeRequest()

            verify(authDataSource).setUserToken(AuthTestData.BEARER_TOKEN)
        }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }

}