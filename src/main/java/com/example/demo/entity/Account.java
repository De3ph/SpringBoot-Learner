package com.example.demo.entity;

import com.example.demo.enums.EnumAccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @SequenceGenerator(
            name = "accountSequence",
            sequenceName = "accountSequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "accountSequence")
    private Long id;

    @NotNull
    @Column(
            name = "account_number",
            unique = true
    )
    private Integer accountNumber;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

    @NotNull
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private EnumAccountType type;

    private Double balance;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "bank_id",
            referencedColumnName = "id"
    )
    private Bank bank;
}
