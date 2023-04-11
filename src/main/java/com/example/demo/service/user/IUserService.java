package com.example.demo.service.user;

import com.example.demo.dto.UserDTO;
import com.example.demo.exception.user.UserNotFoundException;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAll();
    UserDTO getUser(Long id) throws UserNotFoundException;
}
