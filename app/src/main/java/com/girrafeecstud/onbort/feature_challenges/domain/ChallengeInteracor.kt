/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_challenges.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Challenge
import com.girrafeecstud.onbort.feature_challenges.domain.entity.QuestionAnswer
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Submission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ChallengeInteractor @Inject constructor(
    private val repository: IChallengeRepository
) {

    fun getChallenge(challengeId: Long): Flow<BusinessResult<Challenge>> =
        repository.getChallenge(challengeId = challengeId).flowOn(Dispatchers.IO)

    fun sendAnswers(answers: List<QuestionAnswer>): Flow<BusinessResult<Submission>> =
        repository.sendAnswers(answers = answers).flowOn(Dispatchers.IO)

    fun getSubmissions(challengeId: Long): Flow<BusinessResult<List<Submission>>> =
        repository.getSubmissions(challengeId = challengeId).flowOn(Dispatchers.IO)

}