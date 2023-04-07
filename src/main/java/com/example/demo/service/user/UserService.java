package com.example.demo.service.user;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> dtos = new ArrayList<>();
        repository.findAll().forEach(user -> {
            UserDTO dto = UserMapper.INSTANCE.userToUserDto(user);
            dtos.add(dto);
        });
        return dtos;

    }

    @Override
    public UserDTO getUser(Long id)  {
        UserDTO dto = new UserDTO();
        if (repository.existsById(id)){
            dto = UserMapper.INSTANCE.userToUserDto(
                    repository.findById(id).orElse(null)
            );
        }
        return dto;
    }
}
