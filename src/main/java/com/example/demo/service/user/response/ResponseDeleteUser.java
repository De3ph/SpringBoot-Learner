package com.example.demo.service.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDeleteUser {
    private Integer status; // HttpStatus code
    private String message;
    private String path;
}
