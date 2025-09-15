package com.qnadeel.springdemo.application.transaction;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionCommand(UUID userID,BigDecimal amount, String transactionType,
                                       UUID categoryID, String note) {
}