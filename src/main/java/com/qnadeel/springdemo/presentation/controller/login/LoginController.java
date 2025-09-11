package com.qnadeel.springdemo.presentation.controller.login;

import com.qnadeel.springdemo.application.login.LoginCommand;
import com.qnadeel.springdemo.application.login.LoginUseCase;
import com.qnadeel.springdemo.core.entities.user.entity.User;
import com.qnadeel.springdemo.core.securiry.JwtGenerator;
import com.qnadeel.springdemo.presentation.dto.login.LoginRequest;
import com.qnadeel.springdemo.presentation.dto.login.LoginResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class LoginController {

    private final LoginUseCase loginUseCase;
    private final JwtGenerator jwtGenerator;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        User user = loginUseCase.execute
                (new LoginCommand(request.emailOrUsername(), request.password()));
        String token = jwtGenerator.generateToken(user.getId(), user.getEmail());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new LoginResponse(token,user));
    }
}
