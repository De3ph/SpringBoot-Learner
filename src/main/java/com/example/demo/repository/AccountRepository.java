package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.enums.EnumAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.type = :account_type")
    List<Account> findAllByAccountType(@Param("account_type") EnumAccountType accountType);

    Account findLastByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE accounts SET name = :name WHERE id = :id",
            nativeQuery = true
    )
    int updateAccountName(@Param("id") Long id, @Param("name") String name);
}
