package com.qnadeel.springdemo.application;

import com.qnadeel.springdemo.application.RegisterAccount.CreateCategoryCommand;
import com.qnadeel.springdemo.core.entities.category.Category;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCategoryUseCase {

    private final UserRepository userRepository;


}