package com.qnadeel.springdemo.presentation.dto.login;

import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class LoginResponse {

    private final UUID id;
    private final String username;
    private final String email;
    private final String token;

    public LoginResponse(String token, User user) {
        this.id = user.getId();
        this.username = user.getUserName();
        this.email = user.getEmail();
        this.token = token;
    }
}
