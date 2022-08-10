package com.springsecurity.springsecurity.service.impl;

import com.springsecurity.springsecurity.entity.BaseUser;
import com.springsecurity.springsecurity.exceptions.UserException;
import com.springsecurity.springsecurity.payload.request.UserRequest;
import com.springsecurity.springsecurity.payload.response.UserResponse;
import com.springsecurity.springsecurity.repository.UserServiceRepository;
import com.springsecurity.springsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceRepository userServiceRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        if(userServiceRepository.findByEmail(userRequest.getEmail())!=null) throw new UserException("User with email "+ userRequest.getEmail() + " already exist");
        BaseUser baseUser = BaseUser.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastname())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .createdDate(Instant.now())
                .build();
        BaseUser savedUser = userServiceRepository.save(baseUser);
        savedUser.setPassword("");
        return modelMapper.map(savedUser,UserResponse.class);
    }


}
