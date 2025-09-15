package com.qnadeel.springdemo.application.user.login;

public record LoginCommand(String emailOrUsername, String password) {
}
