package com.qnadeel.springdemo.presentation.dto.user.RegisterAccount;

import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RegisterAccountResponse {

    private final UUID id;
    private final String email;
    private final String userName;

    public RegisterAccountResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
    }
}
