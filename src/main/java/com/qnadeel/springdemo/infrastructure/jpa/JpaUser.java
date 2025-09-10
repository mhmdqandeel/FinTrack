package com.qnadeel.springdemo.infrastructure.jpa;

import com.qnadeel.springdemo.core.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaUser extends JpaRepository<User, UUID> {
    Optional<User> findByUserName(String userName);
}
