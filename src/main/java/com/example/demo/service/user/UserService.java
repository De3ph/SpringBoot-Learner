package com.example.demo.service.user;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

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
    public List<UserDTO> getAll() {
        List<UserDTO> dtos = new ArrayList<>();
        repository.findAll().forEach(user -> {
            UserDTO dto = UserMapper.INSTANCE.userToUserDto(user);
            if (dto != null) {
                dtos.add(dto);
                logger.info("USER MAPPED SUCCESSFULLY TO DTO. UserDTO: " + dto);
            }
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
