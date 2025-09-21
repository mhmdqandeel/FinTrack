package com.qnadeel.springdemo.application.category;

import java.util.UUID;

public record CreateCategoryCommand(UUID userId, String category) {
}
