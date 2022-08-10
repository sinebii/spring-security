package com.springsecurity.springsecurity.repository;

import com.springsecurity.springsecurity.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserServiceRepository extends JpaRepository<BaseUser,Long> {

   BaseUser findByEmail(String email);
}
