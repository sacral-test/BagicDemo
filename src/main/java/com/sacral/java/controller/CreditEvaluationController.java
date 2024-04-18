package com.sacral.java.controller;

import com.sacral.java.service.CreditEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditEvaluationController {

    private final CreditEvaluationService creditEvaluationService;

    @Autowired
    public CreditEvaluationController(CreditEvaluationService creditEvaluationService) {
        this.creditEvaluationService = creditEvaluationService;
    }

    @GetMapping("/credit-evaluation/{income}/{score}")
    public String validateCreditEvaluation(@PathVariable double income, @PathVariable int score) {
        return creditEvaluationService.validateCreditEvaluation(income, score);
    }
}