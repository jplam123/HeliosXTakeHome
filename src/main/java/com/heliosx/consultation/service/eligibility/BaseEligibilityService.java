package com.heliosx.consultation.service.eligibility;

import com.heliosx.consultation.model.answer.Answer;

import java.util.List;

public class BaseEligibilityService {

    protected boolean hasRequiredAnswers(List<Answer> answers) {
        return answers.stream().anyMatch(answer -> "required".equals(answer.getAnswer()));
    }
}
