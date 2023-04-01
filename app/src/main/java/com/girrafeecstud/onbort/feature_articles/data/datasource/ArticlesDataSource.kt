/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.datasource

import com.girrafeecstud.core_base.base.ExceptionType
import com.girrafeecstud.core_base.base.NoNetworkConnectionException
import com.girrafeecstud.core_base.domain.base.BusinessErrorType
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_articles.data.network.api.ArticlesApi
import com.girrafeecstud.onbort.feature_articles.data.network.mapper.ArticleDtoEntityMapper
import com.girrafeecstud.onbort.feature_articles.data.network.mapper.ArticlesListDtoEntityMapper
import com.girrafeecstud.onbort.feature_articles.domain.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class ArticlesDataSource @Inject constructor(
    private val api: ArticlesApi,
    private val articleMapper: ArticleDtoEntityMapper,
    private val articleListMapper: ArticlesListDtoEntityMapper
) : IArticlesDataSource {

    override suspend fun getArticles(token: String): Flow<BusinessResult<List<Article>>> =
        flow {

            try {
                val response = api.getArticles(authorizationToken = token)
                val responseBody = response.body()

                if (response.isSuccessful && responseBody != null) {
                    val articles = articleListMapper.map(responseBody)
                    emit(BusinessResult.Success(data = articles))
                }

            } catch (exception: NoNetworkConnectionException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.NO_INTERNET_CONNECTION))
            } catch (exception: SocketTimeoutException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }catch (exception: IOException) {
                exception.printStackTrace()
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }
        }.flowOn(Dispatchers.IO)

    override suspend fun getArticle(articleId: Long, token: String):
            Flow<BusinessResult<Article>> =
        flow {

            try {
                val response = api.getArticle(
                    articleId = articleId,
                    authorizationToken = token
                )
                val responseBody = response.body()

                if (response.isSuccessful && responseBody != null) {
                    val articles = articleMapper.map(responseBody)
                    emit(BusinessResult.Success(data = articles))
                }

            } catch (exception: NoNetworkConnectionException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.NO_INTERNET_CONNECTION))
            } catch (exception: SocketTimeoutException) {
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }catch (exception: IOException) {
                exception.printStackTrace()
                emit(BusinessResult.Exception(exceptionType = ExceptionType.INTERNET_CONNECTION_TIMEOUT))
            }
        }.flowOn(Dispatchers.IO)
}