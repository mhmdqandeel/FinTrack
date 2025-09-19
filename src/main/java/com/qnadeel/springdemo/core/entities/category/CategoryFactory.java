package com.qnadeel.springdemo.core.entities.category;

import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryFactory {

    public Category create(String category, User user) {
        return Category.builder()
                .name(category)
                .createdBy(user)
                .build();
    }
}
