package com.qnadeel.springdemo.core.securiry;

import java.util.Optional;

public interface JwtExtractor {
    Optional<String> extractUsername(String token);
    boolean validateToken(String token, String userName);
}
