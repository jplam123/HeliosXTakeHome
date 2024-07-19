package com.heliosx.consultation.controller;

import com.heliosx.consultation.repostitory.AnswerRepository;
import com.heliosx.consultation.service.eligibility.GenovianPearEligibilityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("eligibility")
public class EligibilityController {

    GenovianPearEligibilityService genovianPearEligibilityService;

    AnswerRepository answerRepository;

    @GetMapping("/genovian-pear-allergy/{userId}")
    public Boolean checkGenovianPearAllergyEligibility(@PathVariable String userId) {
        return genovianPearEligibilityService.checkEligibility(
                answerRepository.findByUserIdAndQuestionIds(
                        userId, genovianPearEligibilityService.getRequiredQuestionIds()
                )
        );
    }
}
