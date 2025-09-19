package com.qnadeel.springdemo.core.entities.user;

import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.entities.user.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserFactory {

    private final PasswordEncoder passwordEncoder;

    public User create(String name, String email, String rawPassword) {
        String encryptedPassword = passwordEncoder.encode(rawPassword);
        return User.builder()
                .userName(name)
                .email(email)
                .password(encryptedPassword)
                .role(Role.USER)
                .build();
    }
}