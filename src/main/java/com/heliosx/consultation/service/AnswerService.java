package com.heliosx.consultation.service;

import com.heliosx.consultation.model.answer.Answer;
import com.heliosx.consultation.repostitory.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void saveAnswers(List<Answer> answers) {
        answerRepository.saveAll(answers);
    }

    public List<Answer> getAnswers(String userId) {
        return answerRepository.findByUserId(userId);
    }

}
