package com.heliosx.consultation.service.eligibility;

import com.heliosx.consultation.model.answer.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Service
public class GenovianPearEligibilityService implements BaseEligibilityService {

    private final Set<String> requiredQuestionIds = Set.of("q1", "q4");

    @Override
    public boolean checkEligibility(List<Answer> answers) {
        if (!requiredQuestionsAnswered(answers)){
            return false;
        }
        for (Answer answer : answers) {
            switch (answer.getQuestionId()) {
                case "q1":
                    if ("Yes".equalsIgnoreCase(answer.getAnswer())) {
                        return false;
                    }
                    break;
                case "q4":
                    if (18 > Integer.parseInt(answer.getAnswer())) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    @Override
    public boolean requiredQuestionsAnswered(List<Answer> answers) {
        Set<String> answeredQuestions = new HashSet<>();
        answers.forEach(answer -> answeredQuestions.add(answer.getQuestionId()));
        return answeredQuestions.containsAll(requiredQuestionIds);
    }

}
