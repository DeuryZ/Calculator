package com.example.Calculator.persistence.DTO;

import com.example.Calculator.persistence.entity.Operation;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OperationDTO {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String operationType;
    private double operand1;
    private double operand2;
    private double result;
    private LocalDateTime timestamp;

    public OperationDTO() {
    }

    public OperationDTO(Long id, String operationType, double operand1, double operand2, double result, LocalDateTime timestamp) {
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
        return "OperationDTO{" +
                "id=" + id +
                ", operationType='" + operationType + '\'' +
                ", operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", result=" + result +
                ", timestamp=" + timestamp +
                '}';
    }

    public static OperationDTO toOperationDTO(Operation operation){
        OperationDTO operationDTO = new OperationDTO();
        operationDTO.setId(operation.getId());
        operationDTO.setOperationType(operation.getOperationType());
        operationDTO.setOperand1(operation.getOperand1());
        operationDTO.setOperand2(operation.getOperand2());
        operationDTO.setResult(operation.getResult());
        operationDTO.setTimestamp(operation.getTimestamp());
        return operationDTO;
    }

    public static List<OperationDTO> toOperationsDTO(List<Operation> operations){
        List<OperationDTO> operationsDTO = new ArrayList<>();
        for(Operation operation : operations){
            operationsDTO.add(toOperationDTO(operation));
        }
        return operationsDTO;
    }
}
