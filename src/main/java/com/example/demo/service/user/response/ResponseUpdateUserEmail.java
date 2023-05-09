package com.example.demo.service.user.response;

import com.example.demo.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseUpdateUserEmail {
    private int status;
    private UserDTO dto;
}
