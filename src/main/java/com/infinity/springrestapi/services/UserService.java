package com.infinity.springrestapi.services;

import com.infinity.springrestapi.dtos.response.UserDto;
import com.infinity.springrestapi.mappers.UserMapper;
import com.infinity.springrestapi.model.User;
import com.infinity.springrestapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public Page<UserDto> getUsers(int page, int size) {
        Pageable pageable   = PageRequest.of(page, size);
        Page<User> userPage = userRepository.findAll(pageable);

        return userPage.map(userMapper::toDto);
    }
}
