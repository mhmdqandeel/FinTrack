package com.qnadeel.springdemo.presentation.controller;

import com.qnadeel.springdemo.application.RegisterAccountCommand;
import com.qnadeel.springdemo.application.RegisterAccountUseCase;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.presentation.dto.RegisterAccountRequest;
import com.qnadeel.springdemo.presentation.dto.RegisterAccountResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Register a new user account", description = "Creates a new user account with name, email, and password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registration successful.Please check your email to verify your account",
                    content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "400", description = "Invalid request payload",
                    content = @Content),
    })
    @PostMapping("/register")
    public ResponseEntity<RegisterAccountResponse> register(@RequestBody RegisterAccountRequest request){
        User user = registerAccountUseCase.execute(new RegisterAccountCommand(
                request.name(),
                request.email(),
                request.password()
        ));

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterAccountResponse(user));
    }
}