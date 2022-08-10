package com.springsecurity.springsecurity.controller;

import com.springsecurity.springsecurity.entity.BaseUser;
import com.springsecurity.springsecurity.payload.request.UserRequest;
import com.springsecurity.springsecurity.payload.response.UserResponse;
import com.springsecurity.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){

        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.OK);

    }
}
