package com.qnadeel.springdemo.application.RegisterAccount;

import com.qnadeel.springdemo.core.entities.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisterAccountUseCaseTest {

    @Autowired
    private RegisterAccountUseCase registerAccountUseCase;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.
    }

    @Test
    void execute() {
    }
}