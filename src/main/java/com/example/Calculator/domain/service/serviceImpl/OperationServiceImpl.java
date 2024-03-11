package com.example.Calculator.domain.service.serviceImpl;

import com.example.Calculator.domain.repository.OperationRepository;
import com.example.Calculator.domain.service.service.OperationService;
import com.example.Calculator.persistence.DTO.OperationDTO;
import com.example.Calculator.persistence.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    @Autowired
    OperationServiceImpl (OperationRepository operationRepository){
        this.operationRepository=operationRepository;
    }


    @Override
    public OperationDTO makeSum(double operand1, double operand2) {
        OperationDTO operationDTO = new OperationDTO();
        operationDTO.setOperationType("Sum");
        operationDTO.setOperand1(operand1);
        operationDTO.setOperand2(operand2);
        operationDTO.setResult(operand1+operand2);
        operationDTO.setTimestamp(LocalDateTime.now());
        operationRepository.save(Operation.toOperation(operationDTO));
        return operationDTO;
    }

    @Override
    public OperationDTO makeRest(double operand1, double operand2) {
        OperationDTO operationDTO = new OperationDTO();
        operationDTO.setOperationType("Rest");
        operationDTO.setOperand1(operand1);
        operationDTO.setOperand2(operand2);
        operationDTO.setResult(operand1-operand2);
        operationDTO.setTimestamp(LocalDateTime.now());
        operationRepository.save(Operation.toOperation(operationDTO));
        return operationDTO;
    }

    @Override
    public OperationDTO makeMul(double operand1, double operand2) {
        OperationDTO operationDTO = new OperationDTO();
        operationDTO.setOperationType("Mul");
        operationDTO.setOperand1(operand1);
        operationDTO.setOperand2(operand2);
        operationDTO.setResult(operand1*operand2);
        operationDTO.setTimestamp(LocalDateTime.now());
        operationRepository.save(Operation.toOperation(operationDTO));
        return operationDTO;
    }

    @Override
    public OperationDTO makeDiv(double operand1, double operand2) {
        OperationDTO operationDTO = new OperationDTO();
        operationDTO.setOperationType("Div");
        operationDTO.setOperand1(operand1);
        operationDTO.setOperand2(operand2);
        operationDTO.setResult(operand1/operand2);
        operationDTO.setTimestamp(LocalDateTime.now());
        operationRepository.save(Operation.toOperation(operationDTO));
        return operationDTO;
    }

    @Override
    public List<OperationDTO> getAllOperations() {
        List<Operation> operations = operationRepository.findAll();
        List<OperationDTO> operationDTOS = OperationDTO.toOperationsDTO(operations);
        return operationDTOS;
    }

    @Override
    public OperationDTO getOperationById(Long id) {
        Optional<Operation> operation = operationRepository.findById(id);
        if(operation.isPresent()){
            return OperationDTO.toOperationDTO(operation.get());
        }
        return null;
    }

    @Override
    public void deleteOperationById(Long id) {
        operationRepository.deleteById(id);
    }

    @Override
    public OperationDTO saveOperation(OperationDTO operationDTO) {
        Operation operation = Operation.toOperation(operationDTO);
        operation.setTimestamp(LocalDateTime.now());
        operationRepository.save(operation);
        operationDTO.setId(operation.getId());
        operationDTO.setTimestamp(operation.getTimestamp());
        return operationDTO;
    }

    @Override
    public OperationDTO updateOperation(OperationDTO operationDTO) {
        Optional<Operation> operation = operationRepository.findById(operationDTO.getId());
        if(operation.isPresent()){
            operation.get().setId(operationDTO.getId());
            operation.get().setOperationType(operationDTO.getOperationType());
            operation.get().setOperand1(operationDTO.getOperand1());
            operation.get().setOperand2(operationDTO.getOperand2());
            operation.get().setResult(operationDTO.getResult());
            operation.get().setTimestamp(LocalDateTime.now());
            operationRepository.save(operation.get());
            return operationDTO;
        }
        return null;
    }
}
