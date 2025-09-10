package com.qnadeel.springdemo.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class RegisterAccountController {

    @PostMapping("/register")
    public String register(@RequestBody RegisterAccountRequest request){
        return "success";
    }
}
