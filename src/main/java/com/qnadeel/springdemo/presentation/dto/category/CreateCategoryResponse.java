package com.qnadeel.springdemo.presentation.dto.category;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateCategoryResponse {

    private UUID id;
    private String name;
    private UUID userId;

    public CreateCategoryResponse(UUID id, String name, UUID userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }
}