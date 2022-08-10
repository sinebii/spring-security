package com.springsecurity.springsecurity.service;
import com.springsecurity.springsecurity.payload.request.UserRequest;

public interface UserService {

    String createUser(UserRequest userRequest);
}
