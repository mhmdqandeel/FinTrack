package com.qnadeel.springdemo.infrastructure.jpa;

import com.qnadeel.springdemo.core.entities.user.User;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaUserRepository implements UserRepository {
    private final JpaUser jpaUser;

    @Override
    public Optional<User> findByUserName(String userName) {
        return jpaUser.findByUsername(userName);
    }
}