package com.example.Calculator.domain.service.service;

import com.example.Calculator.persistence.DTO.OperationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OperationService {

    //-------------------Principal Operations-------------------
    OperationDTO makeSum(double operand1, double operand2);
    OperationDTO makeRest(double operand1, double operand2);
    OperationDTO makeMul(double operand1, double operand2);
    OperationDTO makeDiv(double operand1, double operand2);

    //-------------------Extra Operations-------------------
    //ResponseEntity<OperationDTO> makeDiv(double operand1, double operand2);
    //ResponseEntity<OperationDTO> makeDiv(double operand1, double operand2);
    //ResponseEntity<OperationDTO> makeDiv(double operand1, double operand2);
    //ResponseEntity<OperationDTO> makeDiv(double operand1, double operand2);


    //-------------------General CRUD-------------------
    List<OperationDTO> getAllOperations();
    OperationDTO getOperationById(Long id);
    void deleteOperationById(Long id);
    OperationDTO saveOperation(OperationDTO operationDTO);
    OperationDTO updateOperation(OperationDTO operationDTO);

}