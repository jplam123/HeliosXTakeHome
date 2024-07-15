package com.heliosx.consultation.data;

import com.heliosx.consultation.model.question.FreeTextQuestion;
import com.heliosx.consultation.model.question.MultipleChoiceQuestion;
import com.heliosx.consultation.repostitory.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * This class is being used, instead of using a repository, and the actual databases as per the instructions in the take
 * home allow.
 */
@Component
public class DataLoader implements CommandLineRunner {

        private final QuestionRepository questionRepository;

        public DataLoader(QuestionRepository questionRepository) {
            this.questionRepository = questionRepository;
        }

        @Override
        public void run(String... args) {
            FreeTextQuestion q1 = new FreeTextQuestion();
            q1.setQuestionText("Please describe what happens when you have Genovian Pear");
            q1.setCharLimit(500);

            MultipleChoiceQuestion q2 = new MultipleChoiceQuestion();
            q2.setQuestionText("Do you have any known allergies to medications?");
            q2.setOptions(Arrays.asList("Yes", "No"));

            MultipleChoiceQuestion q3 = new MultipleChoiceQuestion();
            q3.setQuestionText("What were you assigned at birth?");
            q3.setOptions(Arrays.asList("Male", "Female", "Other", "I do not wish to answer"));

            questionRepository.saveAll(Arrays.asList(q1, q2, q3));
        }
    }

