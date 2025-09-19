package com.qnadeel.springdemo.presentation.dto.category;

import com.qnadeel.springdemo.core.entities.category.Category;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateCategoryResponse {

    private final UUID id;
    private final String name;
    private final UUID userId;

    public CreateCategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.userId = category.getCreatedBy().getId();
    }
}