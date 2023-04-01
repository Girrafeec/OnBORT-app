/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.repository

import com.girrafeecstud.core_base.domain.base.BusinessErrorType
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_articles.data.datasource.IArticlesDataSource
import com.girrafeecstud.onbort.feature_articles.domain.Article
import com.girrafeecstud.onbort.feature_articles.domain.IArticlesRepository
import com.girrafeecstud.onbort.feature_auth.common.datasource.IAuthDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val articlesDataSource: IArticlesDataSource,
    private val authDataSource: IAuthDataSource
) : IArticlesRepository {

    private val articlesRepositoryScope = CoroutineScope(
        SupervisorJob() + Dispatchers.IO
    )


    override suspend fun getArticleList(): Flow<BusinessResult<List<Article>>> =
        authDataSource.getUserToken().flatMapLatest { authResult ->
            when (authResult) {
                is BusinessResult.Success -> {
                    val token = authResult.data
                    if (token != null)
                        articlesDataSource.getArticles(token = token)
                    else
                        flowOf(BusinessResult.Error(businessErrorType = BusinessErrorType.USER_UNAUTHORIZED))
                }
                is BusinessResult.Error -> flowOf(authResult)
                is BusinessResult.Exception -> flowOf(authResult)
            }
        }

    override suspend fun getArticle(articleId: Long): Flow<BusinessResult<Article>> =
        authDataSource.getUserToken().flatMapLatest { authResult ->
            when (authResult) {
                is BusinessResult.Success -> {
                    val token = authResult.data
                    if (token != null)
                        articlesDataSource.getArticle(articleId = articleId, token = token)
                    else
                        flowOf(BusinessResult.Error(businessErrorType = BusinessErrorType.USER_UNAUTHORIZED))
                }
                is BusinessResult.Error -> flowOf(authResult)
                is BusinessResult.Exception -> flowOf(authResult)
            }
        }
}