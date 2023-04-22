package com.example.demo.dto;

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
public class AccountDTO {
    private String ownerName;
    private String name;
    private EnumAccountType type;
    private BigInteger balance;
}
