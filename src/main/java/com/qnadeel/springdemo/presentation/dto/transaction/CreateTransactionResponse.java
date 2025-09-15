package com.qnadeel.springdemo.presentation.dto.transaction;

import com.qnadeel.springdemo.core.entities.transaction.entity.Transaction;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class CreateTransactionResponse {

    private final UUID transactionId;
    private final String transactionType;
    private final String transactionDate;
    private final BigDecimal transactionAmount;
    private final String transactionNote;
    private final UUID categoryId;

    public CreateTransactionResponse(Transaction transaction) {
        this.transactionId = transaction.getId();
        this.transactionType = transaction.getType().name();
        this.transactionDate = transaction.getDate().toString();
        this.transactionAmount = transaction.getAmount();
        this.transactionNote = transaction.getNote();
        this.categoryId = transaction.getCategory() != null
                ? transaction.getCategory().getId()
                : null;
    }
}
