package com.example.demo.service.user;

import com.example.demo.exception.user.UserNotFoundException;
import com.example.demo.service.user.response.ResponseDeleteUser;
import com.example.demo.service.user.response.ResponseGetAll;
import com.example.demo.service.user.response.ResponseGetUser;
import com.example.demo.service.user.response.ResponseUpdateUserEmail;

public interface IUserService {
    ResponseGetAll getAll();
    ResponseGetUser getUser(Long id) throws UserNotFoundException;
    ResponseDeleteUser deleteUser(Long id) throws UserNotFoundException;
    ResponseUpdateUserEmail updateUserEmail(Long id, String email) throws UserNotFoundException;
}
