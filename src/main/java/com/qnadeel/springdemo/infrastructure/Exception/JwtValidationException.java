package com.qnadeel.springdemo.infrastructure.Exception;

public class JwtValidationException extends RuntimeException {
    public JwtValidationException(String message) {
        super(message);
    }
}
