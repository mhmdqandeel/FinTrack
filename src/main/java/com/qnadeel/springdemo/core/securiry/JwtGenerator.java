package com.qnadeel.springdemo.core.securiry;

import java.util.UUID;

public interface JwtGenerator {
    String generateToken(UUID id, String email);
}
