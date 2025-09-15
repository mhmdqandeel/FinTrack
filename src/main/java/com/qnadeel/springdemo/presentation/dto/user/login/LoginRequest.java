package com.qnadeel.springdemo.presentation.dto.user.login;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(String emailOrUsername, @NotBlank String password) {
}