package com.qnadeel.springdemo.application.login;

public record LoginCommand(String emailOrUsername, String password) {
}
