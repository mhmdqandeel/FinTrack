package com.qnadeel.springdemo.application.user.RegisterAccount;

import com.qnadeel.springdemo.core.entities.user.UserFactory;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.shared.exeption.DuplicateResourcesException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegisterAccountUseCase {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    @Transactional
    public User execute(RegisterAccountCommand command){
        String email = command.email();
        if(userRepository.existsByEmail(email)){
            throw new DuplicateResourcesException(email);
        }

        User user = userFactory.create(command.name(), email, command.password());

        return userRepository.save(user);
    }
}