package com.sacral.java.service;

import com.sacral.java.model.CreditEvaluation;
import com.sacral.java.repository.CreditEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditEvaluationService {

    private final CreditEvaluationRepository creditEvaluationRepository;

    @Autowired
    public CreditEvaluationService(CreditEvaluationRepository creditEvaluationRepository) {
        this.creditEvaluationRepository = creditEvaluationRepository;
    }

    // Method to validate credit evaluation
    public CreditEvaluation validateCreditEvaluation(double income, int score) {
        CreditEvaluation creditEvaluation = creditEvaluationRepository.validateCreditEvaluation(income, score);
        if (creditEvaluation != null) {
            if (income >= 30000 && score >= 700) {
                System.out.println("Congratulations! You are eligible for a credit score with a high limit.");
            } else if (income >= 20000 && score >= 600) {
                System.out.println("You are eligible for a credit score with a moderate limit.");
            } else {
                System.out.println("Sorry, you are not eligible for a credit score at this time.");
            }
        } else {
            System.out.println("Sorry, we couldn't find a credit evaluation for your income and credit score.");
        }
        return creditEvaluation;
    }
}