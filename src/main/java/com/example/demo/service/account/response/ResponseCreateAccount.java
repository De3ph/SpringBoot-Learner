package com.example.demo.service.account.response;

import com.example.demo.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCreateAccount {
    private AccountDTO dto;
}
