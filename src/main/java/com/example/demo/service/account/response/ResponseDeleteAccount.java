package com.example.demo.service.account.response;

import com.example.demo.enums.EnumSuccessType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDeleteAccount {
    private EnumSuccessType successType;
}
