package com.example.demo.service.account.request;

import com.example.demo.enums.EnumAccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestCreateAccount {
    private Long userId;
    private String name;
    private EnumAccountType type;
    private BigInteger balance;
}
