package com.qnadeel.springdemo.core.entities.transaction;

import com.qnadeel.springdemo.core.entities.category.Category;
import com.qnadeel.springdemo.core.entities.transaction.entity.Transaction;
import com.qnadeel.springdemo.core.entities.transaction.model.TransactionType;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class TransactionFactory {

    public Transaction create(BigDecimal amount, TransactionType transactionType,
                              Category category, User user, String note) {
        return Transaction.builder()
                .amount(amount)
                .type(transactionType)
                .category(category)
                .user(user)
                .note(note)
                .build();
    }
}
