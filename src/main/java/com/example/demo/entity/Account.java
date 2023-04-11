package com.example.demo.entity;

import com.example.demo.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;

    private String name;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private BigInteger balance;
    private Date createdAt;
    private Date updatedAt;
}
