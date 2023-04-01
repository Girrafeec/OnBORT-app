/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.network.mapper

import com.girrafeecstud.core_base.base.ListMapper
import com.girrafeecstud.onbort.feature_articles.data.network.dto.ArticleDto
import com.girrafeecstud.onbort.feature_articles.domain.Article
import javax.inject.Inject

class ArticlesListDtoEntityMapper @Inject constructor(
    private val chaptersListMapper: ChapterListDtoEntityMapper
)
    : ListMapper<ArticleDto, Article> {

    override fun map(input: List<ArticleDto>): List<Article> =
        input.map { articleDto ->
            Article(
                articleId = articleDto.articleId,
                articleName = articleDto.articleName,
                articleTitleImageUrl = articleDto.articleTitleImageUrl,
                chapters = chaptersListMapper.map(articleDto.chapters)
            )
        }
}