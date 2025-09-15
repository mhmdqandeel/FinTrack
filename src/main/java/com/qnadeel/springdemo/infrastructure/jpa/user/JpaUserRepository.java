package com.qnadeel.springdemo.infrastructure.jpa.user;

import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    @Override
    @Transactional
    public Optional<User> findByUserName(String userName) {
        return em.createQuery("SELECT u from User u WHERE u.userName= :userName", User.class)
                .setParameter("userName", userName)
                .getResultList().stream().findFirst();
    }

    @Override
    @Transactional
    public boolean existsByEmail(String email) {
        return !em.createQuery("select 1 from User u where email = :email", Integer.class)
                .setParameter("email", email)
                .setMaxResults(1)
                .getResultList()
                .isEmpty();
    }

    @Override
    @Transactional
    public Optional<User> findByEmailOrUsername(String username, String email) {
       return em.createQuery("SELECT u from User u where userName = :username or email= : email", User.class)
               .setParameter("username", username)
               .setParameter("email", email)
               .getResultList().stream().findFirst();
    }

    @Override
    @Transactional
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public void deleteAll() {
        em.createQuery("delete from User");
    }

    @Override
    public Optional<User> findById(UUID id) {
        return em.createQuery("SELECT u from User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getResultList().stream().findFirst();

    }
}