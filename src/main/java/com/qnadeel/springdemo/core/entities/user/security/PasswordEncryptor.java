package com.qnadeel.springdemo.core.entities.user.security;

public interface PasswordEncryptor {
    String hash(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}
