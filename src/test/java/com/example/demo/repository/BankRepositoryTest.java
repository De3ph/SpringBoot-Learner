package com.example.demo.repository;

import com.example.demo.entity.Bank;
import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
class BankRepositoryTest {

    @Autowired
    private BankRepository repository;
    @Autowired
    private EntityManager manager;

    User user = User.builder()
            .fullName("John Doe")
            .username("jojoDo")
            .email("johndoe@gmail.com")
            .password("doggoAndfoggo")
            .createdAt(new Date())
            .updatedAt(new Date())
            .build();

    Bank bank = Bank.builder()
            .name("YKB")
            .address("gebze")
            .build();


    @Test
    public void createBank(){
        repository.save(bank);
        Assertions.assertEquals(repository.count(),1);
    }

}