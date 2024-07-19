package com.heliosx.consultation.service;

import com.heliosx.consultation.model.answer.Answer;
import com.heliosx.consultation.repostitory.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void saveAnswers(List<Answer> answers) {
        answers.forEach(answer -> {
            Optional<Answer> existingAnswer = answerRepository.findByUserIdAndQuestionId(answer.getUserId(), answer.getQuestionId());
            if (existingAnswer.isPresent()) {
                Answer updatedAnswer = existingAnswer.get();
                updatedAnswer.setAnswer(answer.getAnswer());
                answerRepository.save(updatedAnswer);
            } else {
                answerRepository.save(answer);
            }
        });
    }

    public List<Answer> getAnswers(String userId) {
        return answerRepository.findByUserId(userId);
    }
}
