package com.example.Calculator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "calculator_operations")
public class CalculatorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private double num1;

    private double num2;
    private String operation;

    public CalculatorModel(Long id, double num1, double num2, String operation) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
