package com.qnadeel.springdemo.presentation.controller;

import com.qnadeel.springdemo.core.entities.user.security.UserPrinciple;
import com.qnadeel.springdemo.presentation.dto.CreateCategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CreateCategoryController {

    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest request,
                                            @AuthenticationPrincipal UserPrinciple user) {
        return ResponseEntity.ok().build();
    }
}
