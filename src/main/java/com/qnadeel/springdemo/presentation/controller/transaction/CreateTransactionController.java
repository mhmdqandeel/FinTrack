package com.qnadeel.springdemo.presentation.controller.transaction;

import com.qnadeel.springdemo.application.transaction.CreateTransactionCommand;
import com.qnadeel.springdemo.application.transaction.CreateTransactionUseCase;
import com.qnadeel.springdemo.core.entities.transaction.entity.Transaction;
import com.qnadeel.springdemo.core.entities.user.security.UserPrinciple;
import com.qnadeel.springdemo.presentation.dto.transaction.CreateTransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@AllArgsConstructor
public class CreateTransactionController {

    private final CreateTransactionUseCase createTransactionUseCase;

    @PostMapping("/")
    public ResponseEntity<?> createTransaction(@RequestBody CreateTransactionRequest request,
                                               @AuthenticationPrincipal UserPrinciple userPrinciple) {
        Transaction transaction = createTransactionUseCase.execute(new CreateTransactionCommand(
                userPrinciple.getUserId(),
                request.amount(),
                request.transactionType(),
                request.categoryID(),
                request.note()
        ));
        return ResponseEntity.ok().build();
    }
}