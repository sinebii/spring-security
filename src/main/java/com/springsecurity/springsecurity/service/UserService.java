package com.springsecurity.springsecurity.service;
import com.springsecurity.springsecurity.payload.request.UserRequest;
import com.springsecurity.springsecurity.payload.response.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);
}
