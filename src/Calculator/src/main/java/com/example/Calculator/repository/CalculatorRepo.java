package com.example.Calculator.repository;

import com.example.Calculator.model.CalculatorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepo extends JpaRepository <CalculatorModel, Long> {
}
