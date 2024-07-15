package com.heliosx.consultation.repostitory;

import com.heliosx.consultation.model.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByUserId(String userId);
}
