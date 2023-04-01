/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ArticlesInteractor @Inject constructor(
    private val repository: IArticlesRepository
) {

    suspend fun getArticleList(): Flow<BusinessResult<List<Article>>> =
        repository.getArticleList().flowOn(Dispatchers.IO)

    suspend fun getArticle(articleId: Long): Flow<BusinessResult<Article>> =
        repository.getArticle(articleId = articleId).flowOn(Dispatchers.IO)

}