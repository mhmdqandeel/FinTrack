package com.qnadeel.springdemo.core.securiry;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface JwtExtractor {
    Optional<String> extractUsername(String token);
    boolean validateToken(String token, UserDetails userDetails);
}
