package com.heliosx.consultation.controller;

import com.heliosx.consultation.model.question.Question;
import com.heliosx.consultation.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

}
