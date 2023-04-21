package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @OneToMany(targetEntity = Account.class, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    @JsonBackReference
    private List<Account> accounts;
}
