package com.qnadeel.springdemo.presentation.dto.user.RegisterAccount;

import jakarta.validation.constraints.Email;

public record RegisterAccountRequest(@Email String email,String name, String password) {
}
