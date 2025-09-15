package com.qnadeel.springdemo.application.RegisterAccount;

import java.util.UUID;

public record CreateCategoryCommand(UUID userId, String category) {
}
