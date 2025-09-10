package com.qnadeel.springdemo.core.shared.exeption;

import java.util.UUID;

public class DuplicateResourcesException extends RuntimeException {

    public DuplicateResourcesException(String nameOrEmail) {
        super("Duplicate resource detected: " + nameOrEmail + " already exists.");
    }

    public DuplicateResourcesException(UUID id) {
        super("Resource with ID " + id + " already exists.");
    }

    public DuplicateResourcesException(UUID id, String message) {
        super("Resource with ID " + id + " already exists. " + message);
    }
}
