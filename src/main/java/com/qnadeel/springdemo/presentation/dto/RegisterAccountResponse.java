package com.qnadeel.springdemo.presentation.dto;

import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterAccountResponse {

    private UUID id;
    private String email;
    private String userName;

    public RegisterAccountResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
    }
}
