package com.qnadeel.springdemo.core.entities.user;

import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.shared.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUserName(String userName);

    boolean existsByEmail(String email);

    Optional<User> findByEmailOrUsername(String username, String email);
}