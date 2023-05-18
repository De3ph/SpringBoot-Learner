package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bank {
    @Id
    @SequenceGenerator(
            name = "bankSequence",
            sequenceName = "bankSequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "bankSequence"
    )
    private Long id;
    private String name;
    private String address;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name="user_bank",
            joinColumns = @JoinColumn(
                    name = "bank_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            )
    )
    private List<User> users = new ArrayList<>();
    private final Integer totalEmployee = this.getUsers().size();

    @Builder
    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addUser(User user){
        if (users == null){
            users = new ArrayList<>();
            users.add(user);
            return;
        }
        users.add(user);
    }

}
