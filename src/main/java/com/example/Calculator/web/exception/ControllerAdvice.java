package com.example.Calculator.web.exception;

import com.example.Calculator.persistence.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = InvalidOperationIdException.class)
    public ResponseEntity<ErrorDTO> InvalidOperationIdExceptionHandler(InvalidOperationIdException e){
        ErrorDTO errorDTO = new ErrorDTO(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = OperationNotFoundException.class)
    public ResponseEntity<ErrorDTO> InvalidOperationIdExceptionHandler(OperationNotFoundException e){
        ErrorDTO errorDTO = new ErrorDTO(e.getCode(), e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
