/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.data.network.mapper

import com.girrafeecstud.core_base.base.ListMapper
import com.girrafeecstud.core_base.base.Mapper
import com.girrafeecstud.onbort.feature_articles.data.network.dto.ChapterDto
import com.girrafeecstud.onbort.feature_articles.domain.Chapter

class ChapterListDtoEntityMapper
    : ListMapper<ChapterDto, Chapter> {

    override fun map(input: List<ChapterDto>): List<Chapter> =
        input.map { chapterDto ->
                Chapter(
                    chapterId = chapterDto.chapterId,
                    articleId = chapterDto.articleId,
                    chapterName = chapterDto.chapterName,
                    chapterText = chapterDto.chapterText,
                    chapterImageUrl = chapterDto.chapterImageUrl,
                    extraMediaSourceUrl = chapterDto.extraMediaSourceUrl
                )
        }

}