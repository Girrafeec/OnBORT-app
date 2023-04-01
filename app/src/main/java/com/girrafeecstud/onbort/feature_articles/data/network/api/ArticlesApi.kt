/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.network.api

import com.girrafeecstud.onbort.feature_articles.data.network.config.ArticlesApiConfig
import com.girrafeecstud.onbort.feature_articles.data.network.dto.ArticleDto
import com.girrafeecstud.onbort.feature_auth.login.data.network.config.LoginApiConfig
import com.girrafeecstud.onbort.feature_auth.login.data.network.dto.LoginRequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticlesApi {

    @GET(ArticlesApiConfig.ARTICLES_API_PATH)
    suspend fun getArticles(
        @Header("Authorization") authorizationToken: String?
    ): Response<List<ArticleDto>>

    @GET(ArticlesApiConfig.ARTICLE_API_PATH)
    suspend fun getArticle(
        @Header("Authorization") authorizationToken: String?,
        @Path("id") articleId: Long
    ): Response<ArticleDto>

}