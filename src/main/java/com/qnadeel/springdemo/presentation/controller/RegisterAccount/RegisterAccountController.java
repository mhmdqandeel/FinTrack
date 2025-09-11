package com.qnadeel.springdemo.presentation.controller.RegisterAccount;

import com.qnadeel.springdemo.application.RegisterAccount.RegisterAccountCommand;
import com.qnadeel.springdemo.application.RegisterAccount.RegisterAccountUseCase;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.presentation.dto.RegisterAccount.RegisterAccountRequest;
import com.qnadeel.springdemo.presentation.dto.RegisterAccount.RegisterAccountResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class RegisterAccountController {

    private final RegisterAccountUseCase registerAccountUseCase;

    @PostMapping("/register")
    public ResponseEntity<RegisterAccountResponse> register(@RequestBody @Valid RegisterAccountRequest request){
        User user = registerAccountUseCase.execute(new RegisterAccountCommand(
                request.name(),
                request.email(),
                request.password()
        ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RegisterAccountResponse(user));
    }
}