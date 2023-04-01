/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_challenges.domain

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Challenge
import com.girrafeecstud.onbort.feature_challenges.domain.entity.QuestionAnswer
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Submission
import kotlinx.coroutines.flow.Flow

interface IChallengeRepository {

    fun getChallenge(challengeId: Long): Flow<BusinessResult<Challenge>>

    fun sendAnswers(answers: List<QuestionAnswer>): Flow<BusinessResult<Submission>>

    fun getSubmissions(challengeId: Long): Flow<BusinessResult<List<Submission>>>

}