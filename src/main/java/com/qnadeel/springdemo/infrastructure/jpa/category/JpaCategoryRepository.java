package com.qnadeel.springdemo.infrastructure.jpa.category;

import com.qnadeel.springdemo.core.entities.category.Category;
import com.qnadeel.springdemo.core.entities.category.CategoryRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class JpaCategoryRepository implements CategoryRepository {

    private final EntityManager em;

    @Override
    @Transactional
    public Category save(Category category) {
        em.persist(category);
        return category;
    }

    @Override
    public void deleteAll() {
    }

    @Override
    @Transactional
    public Optional<Category> findById(UUID id) {
        return em.createQuery("SELECT c from Category c WHERE c.id = :id", Category.class)
                .setParameter("id", id)
                .getResultList().stream().findFirst();
    }
}
