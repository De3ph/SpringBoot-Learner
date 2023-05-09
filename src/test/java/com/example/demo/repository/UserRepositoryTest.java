package com.example.demo.repository;

import com.example.demo.entity.User;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
class UserRepositoryTest {


    @Autowired
    private UserRepository repository;

    @Inject
    private EntityManager entityManager;
    // update testlerinden sonra ilgili satırı yeniliyor, böylece satırın yeni update edilmiş halini alabiliyoruz

    @Test
    @DisplayName("Save User")
    void saveUser(){
        User user = User.builder()
                .fullName("John Doe")
                .username("jojoDo")
                .email("johndoe@gmail.com")
                .password("doggoAndfoggo")
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        User savedUser = repository.save(user);

        Assertions.assertEquals(user.getFullName(), savedUser.getFullName());
        Assertions.assertEquals(user.getEmail(), savedUser.getEmail());
    }

    @Test
    @DisplayName("Delete User")
    void deleteUser() {
        User user = User.builder()
                .fullName("John Doe")
                .email("johndoe@gmail.com")
                .password("doggoAndfoggo")
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        User savedUser = repository.save(user);
        Long id = savedUser.getId();
        repository.deleteById(id);

        Assertions.assertFalse(repository.existsById(id));
    }

    @Test
    @DisplayName("Update User Email")

    void updateUserEmail(){
        String oldEmail = "johndoe@gmail.com";
        String newEmail = "messi@gmail.com";

        User user = User.builder()
                .fullName("John Doe")
                .email(oldEmail)
                .password("doggoAndfoggo")
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        User oldUser = repository.save(user);

        Assertions.assertNotEquals(oldUser.getEmail(),newEmail);

        repository.updateEmailById(
                oldUser.getId(),
                newEmail
        );

        User updatedUser = repository.findById(oldUser.getId()).get();
        entityManager.refresh(updatedUser);

        Assertions.assertEquals(updatedUser.getEmail(),newEmail);

    }

}

