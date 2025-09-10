package com.qnadeel.springdemo.infrastructure.jpa;

import com.qnadeel.springdemo.core.entities.user.entity.User;
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
        return jpaUser.findByUserName(userName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUser.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return jpaUser.save(user);
    }
}