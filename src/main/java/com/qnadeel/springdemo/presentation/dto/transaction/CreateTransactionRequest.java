package com.qnadeel.springdemo.presentation.dto.transaction;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionRequest(BigDecimal amount, String transactionType,
                                       UUID categoryID, String note) {
}