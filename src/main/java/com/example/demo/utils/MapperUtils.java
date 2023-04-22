package com.example.demo.utils;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {
    @Autowired
    UserRepository userRepository;

//    @Named("mapIdToUser")
//    public  User mapIdToUser(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
}



