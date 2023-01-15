package com.example.demo.restapijvs.user.service;

import com.example.demo.restapijvs.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getUsers();

    Optional<UserEntity> getUserById(Integer userId);
}
