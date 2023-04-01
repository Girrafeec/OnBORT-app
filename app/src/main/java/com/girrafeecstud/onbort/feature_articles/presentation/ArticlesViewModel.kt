/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.presentation

import androidx.lifecycle.viewModelScope
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.core_ui.presentation.BaseViewModel
import com.girrafeecstud.onbort.feature_articles.domain.ArticlesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesInteractor: ArticlesInteractor
) : BaseViewModel<ArticlesUiState>() {

    override var _state: MutableStateFlow<ArticlesUiState> = MutableStateFlow(ArticlesUiState())
    override val state: StateFlow<ArticlesUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            articlesInteractor.getArticleList()
                .onStart {
                    _state.update {
                        ArticlesUiState(isLoading = true)
                    }
                }
                .onEach { result ->
                    _state.update {
                        ArticlesUiState(isLoading = false)
                    }
                    when (result) {
                        is BusinessResult.Error -> {
                            _state.update {
                                ArticlesUiState(error = result.businessErrorType.name)
                            }
                        }
                        is BusinessResult.Exception -> {
                            _state.update {
                                ArticlesUiState(error = result.exceptionType.name)
                            }
                        }
                        is BusinessResult.Success -> {
                            _state.update {
                                ArticlesUiState(articles = result.data)
                            }
                        }
                    }
                }
                .launchIn(viewModelScope)
        }
    }

}