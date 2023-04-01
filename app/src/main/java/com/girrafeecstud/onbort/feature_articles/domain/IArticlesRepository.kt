/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import kotlinx.coroutines.flow.Flow

interface IArticlesRepository {

    suspend fun getArticleList(): Flow<BusinessResult<List<Article>>>

    suspend fun getArticle(articleId: Long): Flow<BusinessResult<Article>>

}