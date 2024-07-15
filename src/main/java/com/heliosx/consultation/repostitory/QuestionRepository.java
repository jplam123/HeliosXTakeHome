package com.heliosx.consultation.repostitory;

import com.heliosx.consultation.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
