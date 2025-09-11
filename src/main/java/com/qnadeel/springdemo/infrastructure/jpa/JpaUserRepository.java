package com.qnadeel.springdemo.infrastructure.jpa;

import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaUserRepository implements UserRepository {
    private final JpaUser jpaUser;

    private final EntityManager em;

    @Override
    public Optional<User> findByUserName(String userName) {
        return em.createQuery("SELECT u from User u WHERE u.userName= :userName", User.class)
                .setParameter("userName", userName)
                .getResultList().stream().findFirst();
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUser.existsByEmail(email);
    }

    @Override
    public Optional<User> findByEmailOrUsername(String username, String email) {
        return jpaUser.findByEmailOrUserName(username, email);
    }

    @Override
    @Transactional
    public User save(User user) {
        em.persist(user);
        return user;
    }
}