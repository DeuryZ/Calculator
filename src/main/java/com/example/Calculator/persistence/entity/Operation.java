package com.example.Calculator.persistence.entity;

import com.example.Calculator.persistence.DTO.OperationDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String operationType;
    private double operand1;
    private double operand2;
    private double result;
    private LocalDateTime timestamp;

    public Operation() {
    }

    public Operation(Long id, String operationType, double operand1, double operand2, double result, LocalDateTime timestamp) {
        this.id = id;
        this.operationType = operationType;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operationType='" + operationType + '\'' +
                ", operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", result=" + result +
                ", timestamp=" + timestamp +
                '}';
    }
    public static Operation toOperation(OperationDTO operationDTO){
        Operation operation = new Operation();
        operation.setId(operationDTO.getId());
        operation.setOperationType(operationDTO.getOperationType());
        operation.setOperand1(operationDTO.getOperand1());
        operation.setOperand2(operationDTO.getOperand2());
        operation.setResult(operationDTO.getResult());
        operation.setTimestamp(operationDTO.getTimestamp());
        return operation;
    }
}
