package com.example.demo.restapijvs.user.service;

import com.example.demo.restapijvs.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getUsers();
}
