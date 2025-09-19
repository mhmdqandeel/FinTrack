package com.qnadeel.springdemo.presentation.controller;

import com.qnadeel.springdemo.application.CreateCategoryUseCase;
import com.qnadeel.springdemo.application.RegisterAccount.CreateCategoryCommand;
import com.qnadeel.springdemo.core.entities.category.Category;
import com.qnadeel.springdemo.core.entities.user.security.UserPrinciple;
import com.qnadeel.springdemo.presentation.dto.category.CreateCategoryRequest;
import com.qnadeel.springdemo.presentation.dto.category.CreateCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CreateCategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;

    @PostMapping("/")
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest request,
                                            @AuthenticationPrincipal UserPrinciple user) {

        Category category = createCategoryUseCase
                .execute(new CreateCategoryCommand(user.getUserId(), request.category()));

        CreateCategoryResponse responseData = new CreateCategoryResponse(category);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseData);
    }
}