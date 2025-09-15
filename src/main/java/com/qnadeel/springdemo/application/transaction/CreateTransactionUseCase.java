package com.qnadeel.springdemo.application.transaction;

import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTransactionUseCase {

    private final UserRepository userRepository;

    public void execute(CreateTransactionCommand command) {
        User user =
    }
}