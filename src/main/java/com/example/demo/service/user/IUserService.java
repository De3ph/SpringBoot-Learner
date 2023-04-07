package com.example.demo.service.user;

import com.example.demo.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAll();
    UserDTO getUser(Long id);
}
