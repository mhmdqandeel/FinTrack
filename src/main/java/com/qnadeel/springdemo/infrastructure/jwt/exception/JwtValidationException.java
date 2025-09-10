package com.qnadeel.springdemo.infrastructure.jwt.exception;

public class JwtValidationException extends RuntimeException {
    public JwtValidationException(String message) {
        super(message);
    }
}
