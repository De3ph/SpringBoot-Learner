package com.example.demo.entity;

import com.example.demo.enums.EnumAccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotNull
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private EnumAccountType type;

    private BigInteger balance;
    private Date createdAt;
    private Date updatedAt;
}
