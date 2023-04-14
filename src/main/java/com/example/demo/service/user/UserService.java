package com.example.demo.service.user;

import com.example.demo.dto.UserDTO;
import com.example.demo.exception.user.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.user.response.ResponseDeleteUser;
import com.example.demo.service.user.response.ResponseGetAllUser;
import com.example.demo.service.user.response.ResponseGetUser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService implements IUserService {
    private final UserRepository repository;
    private final Logger logger = Logger.getLogger(UserService.class.getName());

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseGetAllUser getAll() {
        ResponseGetAllUser response = new ResponseGetAllUser();
        List<UserDTO> dtos = new ArrayList<>();
        repository.findAll().forEach(user -> {
            UserDTO dto = UserMapper.INSTANCE.userToUserDto(user);
            if (dto != null) {
                dtos.add(dto);
                logger.info("USER MAPPED SUCCESSFULLY TO DTO. UserDTO: " + dto);
            }
        });
        response.setUsers(dtos);
        return response;

    }

    @Override
    public ResponseGetUser getUser(Long id) throws UserNotFoundException {
        ResponseGetUser response = new ResponseGetUser();
        response.setUser(UserMapper.INSTANCE.userToUserDto(
                repository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found","/user/getUser", "User id: " + id))));
        return response;
    }

    @Override
    public ResponseDeleteUser deleteUser(@RequestBody Long id) throws UserNotFoundException {
        repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found","/user/deleteUser", "User id: " + id));
        repository.deleteById(id);
        return new ResponseDeleteUser(HttpStatus.OK.value(), "User deleted successfully", "/user/deleteUser");
    }


}
