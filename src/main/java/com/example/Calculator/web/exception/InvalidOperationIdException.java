package com.example.Calculator.web.exception;

public class InvalidOperationIdException extends RuntimeException {
    private String code;

    public InvalidOperationIdException(String code, String message) {
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
