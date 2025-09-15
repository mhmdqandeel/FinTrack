package com.qnadeel.springdemo.application.transaction;

import com.qnadeel.springdemo.core.entities.category.Category;
import com.qnadeel.springdemo.core.entities.category.CategoryRepository;
import com.qnadeel.springdemo.core.entities.transaction.TransactionRepository;
import com.qnadeel.springdemo.core.entities.transaction.entity.Transaction;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTransactionUseCase {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final TransactionRepository transactionRepository;

    public Transaction execute(CreateTransactionCommand command) {
        User user = userRepository.getOrThrowByID(command.userID());

        Category category = categoryRepository.getOrThrowByID(command.categoryID());

        Transaction transaction = Transaction.builder()
                .amount(command.amount())
                .type(command.transactionType())
                .category(category)
                .user(user)
                .note(command.note())
                .build();

        return transactionRepository.save(transaction);
    }
}