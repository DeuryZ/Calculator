package com.example.Calculator.web.controller;

import com.example.Calculator.domain.service.serviceImpl.OperationServiceImpl;
import com.example.Calculator.persistence.DTO.OperationDTO;
import com.example.Calculator.web.exception.InvalidOperationIdException;
import com.example.Calculator.web.exception.OperationNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {
    private final OperationServiceImpl operationService;

    public OperationController(OperationServiceImpl operationService){
        this.operationService=operationService;
    }

    @GetMapping
    public List<OperationDTO> getAllOperations(){
        return operationService.getAllOperations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationDTO> getOperationById(@PathVariable String id){
        try{
            OperationDTO operationDTO = operationService.getOperationById(Long.parseLong(id));
            if(operationDTO == null){
                throw new OperationNotFoundException("operationId", "Operation not found");
            }

            return ResponseEntity.ok(operationDTO);

        }catch (NumberFormatException e){
            throw new InvalidOperationIdException("operationId", "Invalid ID");
        }
    }


    @DeleteMapping("/{id}")
    public void deleteOperationById(@PathVariable String id){
        try{
            OperationDTO operationDTO = operationService.getOperationById(Long.parseLong(id));
            if(operationDTO == null){
                throw new OperationNotFoundException("operationId", "Operation not found");
            }
            operationService.deleteOperationById(Long.parseLong(id));
        }catch (NumberFormatException e){
            throw new InvalidOperationIdException("operationId", "Invalid ID");
        }
    }

    @PostMapping
    public ResponseEntity<OperationDTO> saveOperation(@RequestBody OperationDTO operationDTO){
        try{
            OperationDTO operation = operationService.saveOperation(operationDTO);
            return ResponseEntity.ok(operation);
        }catch (NumberFormatException e){
            throw new InvalidOperationIdException("Error saving operation", "Invalid body");
        }
    }

    @PutMapping
    public ResponseEntity<OperationDTO> updateOperation(@RequestBody OperationDTO operationDTO){
        try{
            OperationDTO operation = operationService.updateOperation(operationDTO);
            if(operation == null){
                throw new OperationNotFoundException("operationId", "Operation not found");
            }
            return ResponseEntity.ok(operation);
        }catch (NumberFormatException e){
            throw new InvalidOperationIdException("Error updating operation", "Invalid body");
        }
    }



    @PostMapping("/sum")
    public ResponseEntity makeSum(@RequestBody OperationDTO operationDTO) {
        if(operationDTO == null || operationDTO.getOperand1() == null || operationDTO.getOperand2() == null) {
            throw new OperationNotFoundException("operationId", "Invalid body");
        }
        return ResponseEntity.ok(operationService.makeSum(operationDTO.getOperand1(), operationDTO.getOperand2()));
    }

}
