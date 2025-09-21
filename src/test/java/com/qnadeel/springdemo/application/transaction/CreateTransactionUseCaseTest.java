package com.qnadeel.springdemo.application.transaction;

import com.qnadeel.springdemo.core.entities.category.Category;
import com.qnadeel.springdemo.core.entities.category.CategoryRepository;
import com.qnadeel.springdemo.core.entities.transaction.TransactionFactory;
import com.qnadeel.springdemo.core.entities.transaction.TransactionRepository;
import com.qnadeel.springdemo.core.entities.transaction.entity.Transaction;
import com.qnadeel.springdemo.core.entities.transaction.model.TransactionType;
import com.qnadeel.springdemo.core.entities.user.UserRepository;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.presentation.dto.transaction.CreateTransactionRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CreateTransactionUseCaseTest {

    @InjectMocks
    private CreateTransactionUseCase underTest;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionFactory transactionFactory;



    @Test
    void should_create_transaction_successfully() {
        UUID userID = UUID.randomUUID();
        UUID categoryID = UUID.randomUUID();

        CreateTransactionCommand command = new CreateTransactionCommand
                (userID, new BigDecimal(150), TransactionType.EXPENSE, categoryID, "note");

        User user = new User();
        Category category = new Category();

        Transaction transaction = new Transaction();
        Transaction savedTransaction = new Transaction();

        when(userRepository.getOrThrowByID(userID)).thenReturn(user);
        when(categoryRepository.getOrThrowByID(categoryID)).thenReturn(category);
        when(transactionFactory.create(command.amount(), command.transactionType(), category, user, command.note())).thenReturn(transaction);
        when(transactionRepository.save(transaction)).thenReturn(savedTransaction);

        Transaction result = underTest.execute(command);

        assertNotNull(result);
        assertEquals(savedTransaction, result);

        verify(userRepository).getOrThrowByID(userID);
        verify(categoryRepository).getOrThrowByID(categoryID);
        verify(transactionFactory).create(command.amount(), command.transactionType(), category, user, command.note());
        verify(transactionRepository).save(transaction);
    }
}