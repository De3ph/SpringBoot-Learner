package com.example.demo.mapper;

import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.utils.MapperUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = MapperUtils.class)
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "ownerName", source = "user", qualifiedByName = "mapUsername")
    AccountDTO toDTO(Account account, User user);

    Account toEntity(AccountDTO dto);

    @Named("mapUsername")
    default String mapUsername(User user) {
        return user.getUsername();
    }


}
