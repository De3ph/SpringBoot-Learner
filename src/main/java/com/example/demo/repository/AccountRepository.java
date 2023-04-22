package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.enums.EnumAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.type = ?1")
    List<Account> findAllByAccountType(EnumAccountType accountType);

    Account findLastByOrderByIdDesc();
}
