package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Transactional
    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE users SET email = :email WHERE id = :id",
            nativeQuery = true
    )
    void updateEmailById(@Param("id") Long id, @Param("email") String email);

    User findByEmail(String email);

    List<User> findAllByBanksId(Long bankId);
}
