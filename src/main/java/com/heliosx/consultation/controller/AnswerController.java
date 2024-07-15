package com.heliosx.consultation.controller;

import com.heliosx.consultation.model.answer.Answer;
import com.heliosx.consultation.request.AnswerRequest;
import com.heliosx.consultation.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/answers")
    public String submitAnswers(@RequestBody AnswerRequest answerRequest) {
        List<Answer> answerList = answerRequest.getAnswers().stream()
                .map(ans -> new Answer(answerRequest.getUserId(), ans.getQuestionId(), ans.getAnswer()))
                .toList();
        answerService.saveAnswers(answerList);
        return "Successfully submitted answers";
    }

    @GetMapping("/answers/{userId}")
    public List<Answer> getAnswers(@PathVariable String userId) {
        return answerService.getAnswers(userId);
    }
}
