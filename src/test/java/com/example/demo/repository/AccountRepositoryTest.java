package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.enums.EnumAccountType;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
class AccountRepositoryTest {
    @Autowired
    private AccountRepository repository;
    @Inject
    private EntityManager entityManager;

    @Test
    void saveAccount() {
        User user = User.builder()
                .fullName("John Doe")
                .email("johndoe@gmail.com")
                .password("doggoAndfoggo")
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        Account account = Account.builder()
                .name("Account 1")
                .accountNumber(1234567890)
                .type(EnumAccountType.SAVINGS)
                .balance(1000.00)
                .user(user)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        Account savedAccount = repository.save(account);

        Assertions.assertEquals(account.getId(), savedAccount.getId());
    }

    @Test
    void saveAccountWithoutUser() {
        Account account = Account.builder()
                .name("Account 1")
                .accountNumber(1234567890)
                .type(EnumAccountType.SAVINGS)
                .balance(1000.00)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        Assertions.assertThrows(Exception.class, () -> {
            repository.save(account);
        });
    }

    @Test
    void updateAccountName(){
        User user = User.builder()
                .fullName("John Doe")
                .email("johndoe@gmail.com")
                .password("doggoAndfoggo")
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        Account account = Account.builder()
                .name("Account 1")
                .accountNumber(1234567890)
                .type(EnumAccountType.SAVINGS)
                .balance(1000.00)
                .user(user)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        String newAccountName = "New Acc";
        Account oldAccount = repository.save(account);
        repository.updateAccountName(oldAccount.getId(),newAccountName);

        Account updatedAccount = repository.findById(oldAccount.getId()).get();

        entityManager.refresh(updatedAccount);

        Assertions.assertEquals(
                updatedAccount.getName()
                ,
                newAccountName
        );
    }
}