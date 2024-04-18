
package com.sacral.java.repository;

import com.sacral.java.model.CreditEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditEvaluationRepository extends JpaRepository<CreditEvaluation, Long> {

    // Method to validate credit evaluation
    @Query("SELECT ce FROM CreditEvaluation ce WHERE ce.annualIncome >= :income AND ce.creditScore >= :score")
    CreditEvaluation validateCreditEvaluation(double income, int score);
}
