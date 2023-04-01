package com.girrafeecstud.onbort.feature_quests.presentation

import androidx.lifecycle.viewModelScope
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.core_ui.presentation.BaseViewModel
import com.girrafeecstud.onbort.feature_quests.domain.QuestsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestsViewModel @Inject constructor(
    private val questsInteractor: QuestsInteractor
) : BaseViewModel<QuestsUiState>() {
    override var _state: MutableStateFlow<QuestsUiState> = MutableStateFlow(QuestsUiState())
    override val state: StateFlow<QuestsUiState> = _state.asStateFlow()
    init {
        viewModelScope.launch {
            questsInteractor.getQuestList()
                .onStart {
                _state.update { currentState ->
                    currentState.copy(
                        isLoading = true
                    )
                }


            }
                .onEach { result ->
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false
                        )
                    }
                    when(result) {
                        is BusinessResult.Error -> {
                            _state.update { currentState ->
                                currentState.copy(
                                    onError = result.businessErrorType.name
                                )
                            }

                        }
                        is BusinessResult.Success -> {
                            _state.update {currentState ->
                                currentState.copy(
                                    questsList = result.data
                                )
                            }


                        }
                        is BusinessResult.Exception -> {
                            _state.update { currentState ->
                                currentState.copy(
                                    onError = result.exceptionType.name
                                )
                            }

                        }
                    }

                }
                .launchIn(viewModelScope)
        }
    }
}