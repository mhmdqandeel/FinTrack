package com.qnadeel.springdemo.application;

public record RegisterAccountCommand(String name, String email, String password) {
}