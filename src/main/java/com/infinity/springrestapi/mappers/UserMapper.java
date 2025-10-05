package com.infinity.springrestapi.mappers;

import com.infinity.springrestapi.dtos.request.RegisterUserRequest;
import com.infinity.springrestapi.dtos.request.UpdateUserRequest;
import org.mapstruct.Mapper;
import com.infinity.springrestapi.dtos.response.UserDto;
import com.infinity.springrestapi.model.User;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
