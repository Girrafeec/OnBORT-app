/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles

import com.girrafeecstud.onbort.feature_articles.domain.ArticlesInteractor
import com.girrafeecstud.onbort.feature_articles.presentation.ArticleDetailsViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ArticlesViewModelUnitTest {

    private val articlesInteractor: ArticlesInteractor = mock()
    private lateinit var articleDetailsViewModel: ArticleDetailsViewModel

    @Before
    fun setUp() {
        articleDetailsViewModel = ArticleDetailsViewModel(articlesInteractor)
    }

    @Test
    fun `getArticleDetails should update state when articleId is not null`() =
        runBlocking {
        // Given
        articleDetailsViewModel.articleId = 123

        // When
        articleDetailsViewModel.getArticleDetails()

        // Then
        val state = articleDetailsViewModel.state.value
        assertTrue(state.isLoading)
        verify(articlesInteractor.getArticle(articleId = 123))
    } as Unit

//    @Test
//    fun `getArticleDetails should not update state when articleId is null`() =
//        runBlocking {
//        // Given
//        articleDetailsViewModel.articleId = null
//
//        // When
//        articleDetailsViewModel.getArticleDetails()
//
//        // Then
//        val state = articleDetailsViewModel.state.value
//        assertFalse(state.isLoading)
//        assertNull(state.error)
//        assertNull(state.article)
//        verify(articlesInteractor.getArticle(any()))
//    }.let {  }

}