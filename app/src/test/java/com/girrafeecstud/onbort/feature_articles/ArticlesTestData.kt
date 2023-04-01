package com.girrafeecstud.onbort.feature_articles

import com.girrafeecstud.onbort.feature_articles.domain.Article
import com.girrafeecstud.onbort.feature_articles.domain.Chapter

object ArticlesTestData {

    val articles = listOf(
        Article(
            articleId = 1,
            articleName = "Sample Article 1",
            articleTitleImageUrl = "https://example.com/image1.jpg",
            chapters = listOf(
                Chapter(
                    articleId = 1,
                    chapterId = 1,
                    chapterName = "Chapter 1",
                    chapterText = "This is the text for chapter 1.",
                    chapterImageUrl = "https://example.com/chapter1.jpg",
                    extraMediaSourceUrl = "https://example.com/chapter1.mp3"
                ),
                Chapter(
                    articleId = 1,
                    chapterId = 2,
                    chapterName = "Chapter 2",
                    chapterText = "This is the text for chapter 2.",
                    chapterImageUrl = "https://example.com/chapter2.jpg"
                )
            )
        ),
        Article(
            articleId = 2,
            articleName = "Sample Article 2",
            articleTitleImageUrl = "https://example.com/image2.jpg",
            chapters = listOf(
                Chapter(
                    articleId = 2,
                    chapterId = 1,
                    chapterName = "Chapter 1",
                    chapterText = "This is the text for chapter 1.",
                    extraMediaSourceUrl = "https://example.com/chapter1.mp3"
                ),
                Chapter(
                    articleId = 2,
                    chapterId = 2,
                    chapterName = "Chapter 2",
                    chapterText = "This is the text for chapter 2."
                ),
                Chapter(
                    articleId = 2,
                    chapterId = 3,
                    chapterName = "Chapter 3",
                    chapterText = "This is the text for chapter 3."
                )
            )
        )
    )

}