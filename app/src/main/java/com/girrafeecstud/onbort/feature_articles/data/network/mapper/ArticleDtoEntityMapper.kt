/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.network.mapper

import com.girrafeecstud.core_base.base.Mapper
import com.girrafeecstud.onbort.feature_articles.data.network.dto.ArticleDto
import com.girrafeecstud.onbort.feature_articles.domain.Article
import com.girrafeecstud.onbort.feature_articles.domain.Chapter
import javax.inject.Inject

class ArticleDtoEntityMapper @Inject constructor(
    private val chaptersListMapper: ChapterListDtoEntityMapper
) : Mapper<ArticleDto, Article> {

    override fun map(input: ArticleDto): Article =
        with(input) {
            Article(
                articleId = articleId,
                articleName = articleName,
                articleTitleImageUrl = articleTitleImageUrl,
                chapters = chaptersListMapper.map(chapters)
            )
        }
}