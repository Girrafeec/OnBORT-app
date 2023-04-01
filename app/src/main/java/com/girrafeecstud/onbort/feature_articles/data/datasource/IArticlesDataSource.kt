/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.datasource

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_articles.domain.Article
import kotlinx.coroutines.flow.Flow

interface IArticlesDataSource {

    suspend fun getArticles(token: String): Flow<BusinessResult<List<Article>>>

    suspend fun getArticle(articleId: Long, token: String): Flow<BusinessResult<Article>>

}