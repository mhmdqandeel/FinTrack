package com.qnadeel.springdemo.application.category;

import com.qnadeel.springdemo.core.entities.category.Category;
import com.qnadeel.springdemo.core.entities.category.CategoryFactory;
import com.qnadeel.springdemo.core.entities.category.CategoryRepository;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CreateCategoryUseCaseTest {

    @InjectMocks
    private CreateCategoryUseCase underTest;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CategoryFactory categoryFactory;

    @Test
    void should_create_category_successfully() {
        UUID userId = UUID.randomUUID();

        CreateCategoryCommand command = new CreateCategoryCommand(userId, "category");

        Category category = new Category();
        Category savedCategory = new Category();

        User user = new User();

        when(userRepository.getOrThrowByID(userId)).thenReturn(user);
        when(categoryFactory.create(command.category(), user)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(savedCategory);

        Category result = underTest.execute(command);

        assertNotNull(result);
        assertEquals(savedCategory, result);

        verify(userRepository).getOrThrowByID(userId);
        verify(categoryFactory).create(command.category(), user);
        verify(categoryRepository).save(category);
    }
}