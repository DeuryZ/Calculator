package com.example.Calculator.web.exception;

public class OperationNotFoundException extends RuntimeException {
    private String code;

    public OperationNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
