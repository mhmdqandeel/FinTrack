package com.qnadeel.springdemo.presentation.dto.login;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(String emailOrUsername, @NotBlank String password) {
}