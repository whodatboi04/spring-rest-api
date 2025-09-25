package com.infinity.springrestapi.mappers;

import org.mapstruct.Mapper;
import com.infinity.springrestapi.dtos.UserDto;
import com.infinity.springrestapi.entities.User;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
}
