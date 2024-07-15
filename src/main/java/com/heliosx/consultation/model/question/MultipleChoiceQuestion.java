package com.heliosx.consultation.model.question;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class MultipleChoiceQuestion extends Question {
    private List<String> options;
}
