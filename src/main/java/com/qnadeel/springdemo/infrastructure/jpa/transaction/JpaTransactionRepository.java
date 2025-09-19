package com.qnadeel.springdemo.infrastructure.jpa.transaction;

import com.qnadeel.springdemo.core.entities.transaction.TransactionRepository;
import com.qnadeel.springdemo.core.entities.transaction.entity.Transaction;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class JpaTransactionRepository implements TransactionRepository {

    private final EntityManager em;

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
        em.persist(transaction);
        return transaction;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Transaction> findById(UUID id) {
        return Optional.empty();
    }
}
