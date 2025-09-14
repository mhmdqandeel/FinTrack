package com.qnadeel.springdemo.application.login;

import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.entities.user.security.PasswordEncryptor;
import com.qnadeel.springdemo.core.securiry.JwtGenerator;
import com.qnadeel.springdemo.core.shared.exeption.ResourcesNotFoundException;
import com.qnadeel.springdemo.core.shared.exeption.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordEncryptor passwordEncryptor;

    public User execute(LoginCommand command) {
        String emailOrUsername = command.emailOrUsername();
        User user = userRepository.findByEmailOrUsername(emailOrUsername, emailOrUsername)
                .orElseThrow(() -> new ResourcesNotFoundException(emailOrUsername));

        if (!passwordEncryptor.matches(command.password(), user.getPassword())) {
            throw new ValidationException("Invalid password");
        }

        return user;
    }
}