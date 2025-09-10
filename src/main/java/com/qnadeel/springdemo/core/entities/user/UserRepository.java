package com.qnadeel.springdemo.core.entities.user;

import com.qnadeel.springdemo.core.shared.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUserName(String userName);
}
