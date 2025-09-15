package com.qnadeel.springdemo.application.transaction;

import com.qnadeel.springdemo.core.entities.transaction.model.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionCommand(UUID userID,BigDecimal amount, TransactionType transactionType,
                                       UUID categoryID, String note) {
}