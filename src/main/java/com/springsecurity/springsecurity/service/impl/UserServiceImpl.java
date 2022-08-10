package com.springsecurity.springsecurity.service.impl;

import com.springsecurity.springsecurity.entity.BaseUser;
import com.springsecurity.springsecurity.exceptions.UserException;
import com.springsecurity.springsecurity.payload.request.UserRequest;
import com.springsecurity.springsecurity.payload.response.UserResponse;
import com.springsecurity.springsecurity.repository.UserServiceRepository;
import com.springsecurity.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserServiceRepository userServiceRepository;
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        if(userServiceRepository.findByEmail(userRequest.getEmail())!=null) throw new UserException("User with "+userRequest.getEmail() + "Already exist");
        BaseUser baseUser = BaseUser.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastname())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .createdDate(Instant.now())
                .build();
        BaseUser savedUser = userServiceRepository.save(baseUser);
        return UserResponse.builder()
                .firstName(savedUser.getFirstName())
                .lastname(savedUser.getLastName())
                .email(savedUser.getEmail())
                .password(null)
                .build();
    }


}
