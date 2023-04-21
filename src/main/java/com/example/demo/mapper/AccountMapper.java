package com.example.demo.mapper;

import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "ownerName", source = "user")
    AccountDTO toDTO(Account account, User user);
    Account toEntity(AccountDTO dto);

    default String mapUsername(User user){
        return user.getUsername();
    }
}
