/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles

import com.girrafeecstud.core_base.base.enqueueResponse
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_articles.data.datasource.ArticlesDataSource
import com.girrafeecstud.onbort.feature_articles.data.datasource.IArticlesDataSource
import com.girrafeecstud.onbort.feature_articles.data.network.api.ArticlesApi
import com.girrafeecstud.onbort.feature_articles.data.network.mapper.ArticleDtoEntityMapper
import com.girrafeecstud.onbort.feature_articles.data.network.mapper.ArticlesListDtoEntityMapper
import com.girrafeecstud.onbort.feature_articles.data.network.mapper.ChapterListDtoEntityMapper
import com.girrafeecstud.onbort.feature_articles.data.repository.ArticlesRepository
import com.girrafeecstud.onbort.feature_articles.domain.Article
import com.girrafeecstud.onbort.feature_articles.domain.IArticlesRepository
import com.girrafeecstud.onbort.feature_auth.AuthTestData
import com.girrafeecstud.onbort.feature_auth.common.datasource.IAuthDataSource
import com.github.ivanshafran.sharedpreferencesmock.SPMockBuilder
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class ArticlesRepositoryUnitTest {

    private lateinit var articlesDataSource: IArticlesDataSource

    private lateinit var articlesApi: ArticlesApi

    private lateinit var chaptersListMapper: ChapterListDtoEntityMapper

    private lateinit var articleListResponseMapper: ArticlesListDtoEntityMapper

    private lateinit var articleResponseMapper: ArticleDtoEntityMapper

    private lateinit var articlesRepository: IArticlesRepository

    private lateinit var authDataSource: IAuthDataSource

    private lateinit var mockWebServer: MockWebServer

    private lateinit var okHttpClient: OkHttpClient

    private lateinit var sharedPreferencesSPMockBuilder: SPMockBuilder

    @Before
    fun setUp() {
        sharedPreferencesSPMockBuilder = SPMockBuilder()
        okHttpClient = OkHttpClient.Builder().build()
        mockWebServer = MockWebServer()
        articlesApi= Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ArticlesApi::class.java)

        chaptersListMapper = ChapterListDtoEntityMapper()

        articleListResponseMapper =
            ArticlesListDtoEntityMapper(chaptersListMapper)

        articleResponseMapper =
            ArticleDtoEntityMapper(chaptersListMapper)

        articlesDataSource = ArticlesDataSource(
            api = articlesApi,
            articleMapper = articleResponseMapper,
            articleListMapper = articleListResponseMapper
        )

        authDataSource = mock()

        articlesRepository = ArticlesRepository(
            articlesDataSource = articlesDataSource,
            authDataSource = authDataSource
        )

    }

    @Test
    fun `WHEN login is 200 OK EXPECT List of Articles`() =
        runBlocking {
            mockWebServer.enqueueResponse(
                fileName = "ArticlesResponse.json",
                code = 200
            )
            val expectedResult = ArticlesTestData.articles

            var actualResult: List<Article>? = null

            articlesDataSource.getArticles(token = AuthTestData.BEARER_TOKEN)
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

            Assert.assertEquals(expectedResult, actualResult)
        }

    @Test
    fun `EXPECT calling token WHEN calling articles data source`() =
        runBlocking {

            authDataSource = mock()
            articlesDataSource = mock()

            articlesRepository = ArticlesRepository(
                authDataSource = authDataSource,
                articlesDataSource = articlesDataSource
            )

            whenever(authDataSource.getUserToken())
                .thenReturn(flowOf(BusinessResult.Success(data = AuthTestData.BEARER_TOKEN)))

            whenever(articlesDataSource.getArticles(AuthTestData.BEARER_TOKEN))
                .thenReturn(flowOf(BusinessResult.Success(data = ArticlesTestData.articles)))

            articlesRepository.getArticleList().collect()

            verify(authDataSource).getUserToken()

            verify(articlesDataSource).getArticles(AuthTestData.BEARER_TOKEN)
        }.let {  }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }

}