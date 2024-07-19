package com.heliosx.consultation.repostitory;

import com.heliosx.consultation.model.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByUserId(String userId);

    @Query("SELECT a FROM Answer a WHERE a.userId = :userId AND a.questionId IN :questionIds")
    List<Answer> findByUserIdAndQuestionIds(@Param("userId") String userId, @Param("questionIds") Set<String> questionIds);

    Optional<Answer> findByUserIdAndQuestionId(String userId, String questionId);

}
