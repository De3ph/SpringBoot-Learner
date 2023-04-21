package com.example.demo.exception.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountNotFoundException extends RuntimeException{
    private final String path;
    private final String details;
    public AccountNotFoundException(String message, String path, String details) {
        super(message);
        this.path = path;
        this.details = details;
    }
}
