package com.heliosx.consultation.model.question;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FreeTextQuestion extends Question {
    private int charLimit;
}
