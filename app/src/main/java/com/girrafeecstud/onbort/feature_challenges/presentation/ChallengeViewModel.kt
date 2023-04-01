/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_challenges.presentation

import androidx.lifecycle.viewModelScope
import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.core_ui.presentation.BaseViewModel
import com.girrafeecstud.onbort.feature_challenges.domain.ChallengeInteractor
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Challenge
import com.girrafeecstud.onbort.feature_challenges.domain.entity.QuestionAnswer
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChallengeViewModel @Inject constructor(
    private val challengeInteractor: ChallengeInteractor
) : BaseViewModel<ChallengeUiState>() {

    override var _state: MutableStateFlow<ChallengeUiState> = MutableStateFlow(ChallengeUiState())
    override val state: StateFlow<ChallengeUiState> = _state.asStateFlow()

    private val challengeAnswers = mutableListOf<QuestionAnswer>()

    fun getChallenge(challengeId: Long) {
        viewModelScope.launch {
            challengeInteractor.getChallenge(challengeId = challengeId)
                .onStart {
                    _state.update { ChallengeUiState(isLoading = true) }
                }
                .onEach { result ->
                    _state.update { ChallengeUiState(isLoading = false) }
                    when (result) {
                        is BusinessResult.Success -> {
                            // set default data for challengeAnswers
                            //TODO null safety!
                            initChallengeAnswers(challenge = result.data!!)
                            // set challenge state
                            _state.update { ChallengeUiState(challenge = result.data) }
                        }
                        is BusinessResult.Error -> {
                            _state.update { ChallengeUiState(error = result.businessErrorType.name) }
                        }
                        is BusinessResult.Exception -> {
                            _state.update { ChallengeUiState(error = result.exceptionType.name) }
                        }
                    }
                }
                .launchIn(viewModelScope)
        }
    }

    fun sendAnswers() {
        viewModelScope.launch {
            challengeInteractor.sendAnswers(answers = challengeAnswers)
                .onStart {
                    _state.update { ChallengeUiState(isLoading = true) }
                }
                .onEach { result ->
                    _state.update { ChallengeUiState(isLoading = false) }
                    when (result) {
                        is BusinessResult.Success -> {
                            // set submission state
                            _state.update { ChallengeUiState(submission = result.data) }
                        }
                        is BusinessResult.Error -> {
                            _state.update { ChallengeUiState(error = result.businessErrorType.name) }
                        }
                        is BusinessResult.Exception -> {
                            _state.update { ChallengeUiState(error = result.exceptionType.name) }
                        }
                    }
                }
                .launchIn(viewModelScope)

        }
    }

    fun setAnswer(questionId: Long, answerId: Int) {
        for (answer in challengeAnswers)
            if (answer.questionId == questionId)
                answer.answerId = answerId
    }

    //
    private fun initChallengeAnswers(challenge: Challenge) {
        for (question in challenge.questions)
            challengeAnswers.add(
                QuestionAnswer(
                    challengeId = challenge.challengeId,
                    questionId = question.questionId,
                    answerId = null
                )
            )
    }

}