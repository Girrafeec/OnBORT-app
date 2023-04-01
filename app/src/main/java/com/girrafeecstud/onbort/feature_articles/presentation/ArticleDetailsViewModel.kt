/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.presentation

import androidx.lifecycle.viewModelScope
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.core_ui.presentation.BaseViewModel
import com.girrafeecstud.onbort.feature_articles.domain.ArticlesInteractor
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class ArticleDetailsViewModel @Inject constructor(
    private val articlesInteractor: ArticlesInteractor
) : BaseViewModel<ArticleDetailsUiState>() {

    override var _state: MutableStateFlow<ArticleDetailsUiState> = MutableStateFlow(
        ArticleDetailsUiState()
    )
    override val state: StateFlow<ArticleDetailsUiState> = _state.asStateFlow()

    var articleId: Long? = null

    fun getArticleDetails() {
        if (articleId == null)
            return
        viewModelScope.launch {
            articlesInteractor.getArticle(articleId = articleId!!)
                .onStart {
                    _state.update {
                        ArticleDetailsUiState(isLoading = true)
                    }
                }
                .onEach { result ->
                    _state.update {
                        ArticleDetailsUiState(isLoading = false)
                    }
                    when (result) {
                        is BusinessResult.Error -> {
                            _state.update {
                                ArticleDetailsUiState(error = result.businessErrorType.name)
                            }
                        }
                        is BusinessResult.Exception -> {
                            _state.update {
                                ArticleDetailsUiState(error = result.exceptionType.name)
                            }
                        }
                        is BusinessResult.Success -> {
                            _state.update {
                                ArticleDetailsUiState(article = result.data)
                            }
                        }
                    }
                }
                .launchIn(viewModelScope)
        }
    }

}