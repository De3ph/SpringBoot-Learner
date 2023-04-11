package com.example.demo.exception.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
    private final String path;
    private final String details;
    public UserNotFoundException(String message, String path, String details) {
        super(message);
        this.path = path;
        this.details = details;
    }

}
