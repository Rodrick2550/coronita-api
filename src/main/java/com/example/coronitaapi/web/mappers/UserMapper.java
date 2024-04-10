package com.example.coronitaapi.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    CreateUserResponse toCreateUserResponse(User user);

    User toUser(CreateUserRequest createUserRequest);
    UpdateUserResponse toUpdateUserResponse(User user);
}
