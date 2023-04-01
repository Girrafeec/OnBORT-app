/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_challenges.data

import com.girrafeecstud.core_base.domain.base.BusinessResult
import com.girrafeecstud.onbort.feature_challenges.domain.IChallengeRepository
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Challenge
import com.girrafeecstud.onbort.feature_challenges.domain.entity.QuestionAnswer
import com.girrafeecstud.onbort.feature_challenges.domain.entity.Submission
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChallengeRepository @Inject constructor(

) : IChallengeRepository {

    override fun getChallenge(challengeId: Long): Flow<BusinessResult<Challenge>> {
        TODO("Not yet implemented")
    }

    override fun sendAnswers(answers: List<QuestionAnswer>): Flow<BusinessResult<Submission>> {
        TODO("Not yet implemented")
    }

    override fun getSubmissions(challengeId: Long): Flow<BusinessResult<List<Submission>>> {
        TODO("Not yet implemented")
    }
}