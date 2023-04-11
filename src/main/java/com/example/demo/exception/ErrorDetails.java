package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor

public class ErrorDetails {
    private final Date timestamp;
    private final String message;
    private final String details;
    private final String path;
    private final Integer statusCode;
}
