package com.example.demo.service.user;

import com.example.demo.exception.user.UserNotFoundException;
import com.example.demo.service.user.response.ResponseDeleteUser;
import com.example.demo.service.user.response.ResponseGetAllUser;
import com.example.demo.service.user.response.ResponseGetUser;

public interface IUserService {
    ResponseGetAllUser getAll();
    ResponseGetUser getUser(Long id) throws UserNotFoundException;
    ResponseDeleteUser deleteUser(Long id) throws UserNotFoundException;
}
