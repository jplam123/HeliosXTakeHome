package com.heliosx.consultation.request;

import com.heliosx.consultation.model.answer.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest {
    private String userId;
    private List<Answer> answers;
}
