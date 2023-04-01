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
class QuestDetailsViewModel @Inject constructor(
    private val questsInteractor: QuestsInteractor
) : BaseViewModel<QuestDetailsUiState>() {
    override var _state: MutableStateFlow<QuestDetailsUiState> = MutableStateFlow(
        QuestDetailsUiState()
    )
    override val state: StateFlow<QuestDetailsUiState> = _state.asStateFlow()
    fun getQuestDetails(questId: Long) {
        viewModelScope.launch {
            questsInteractor.getQuest(questId)
                .onStart {
                    _state.update {
                        currentState ->
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
                                    quest = result.data
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
