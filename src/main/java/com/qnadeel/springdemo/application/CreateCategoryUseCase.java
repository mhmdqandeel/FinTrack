package com.qnadeel.springdemo.application;

import com.qnadeel.springdemo.application.RegisterAccount.CreateCategoryCommand;
import com.qnadeel.springdemo.core.entities.category.Category;
import com.qnadeel.springdemo.core.entities.category.CategoryRepository;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCategoryUseCase {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public Category execute(CreateCategoryCommand command) {
        User user = userRepository.getOrThrowByID(command.userId());

        Category category = Category.builder()
                .name(command.category())
                .createdBy(user)
                .build();

        return categoryRepository.save(category);
    }
}