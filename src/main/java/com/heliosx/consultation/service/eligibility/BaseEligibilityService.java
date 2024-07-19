package com.heliosx.consultation.service.eligibility;

import com.heliosx.consultation.model.answer.Answer;

import java.util.List;

public interface BaseEligibilityService {
    boolean checkEligibility(List<Answer> answers);
    boolean requiredQuestionsAnswered(List<Answer> answers);
}
