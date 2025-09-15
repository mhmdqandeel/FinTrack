package com.qnadeel.springdemo.presentation.dto.transaction;

import com.qnadeel.springdemo.core.entities.transaction.model.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionRequest(BigDecimal amount, TransactionType transactionType,
                                       UUID categoryID, String note) {
}