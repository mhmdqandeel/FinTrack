package com.qnadeel.springdemo.presentation.controller.transaction;

import com.qnadeel.springdemo.presentation.dto.transaction.CreateTransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@AllArgsConstructor
public class CreateTransactionController {

    @PostMapping("/")
    public ResponseEntity<?> createTransaction(CreateTransactionRequest request) {
        return ResponseEntity.ok().build();
    }
}