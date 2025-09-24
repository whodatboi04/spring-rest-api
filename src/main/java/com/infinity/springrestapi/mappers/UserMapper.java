package com.infinity.springrestapi.mappers;

import org.mapstruct.Mapper;
import com.infinity.springrestapi.dtos.UserDto;
import com.infinity.springrestapi.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
