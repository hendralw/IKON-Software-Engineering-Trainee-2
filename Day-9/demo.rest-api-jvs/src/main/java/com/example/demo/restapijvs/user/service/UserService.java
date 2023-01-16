package com.example.demo.restapijvs.user.service;

import com.example.demo.restapijvs.user.entity.UserEntity;
import com.example.demo.restapijvs.user.model.UserRequestModel;
import com.example.demo.restapijvs.utils.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    ResponseEntity<ResponseApi> getUsers();

    ResponseEntity<ResponseApi> getUserById(Integer userId);

    ResponseEntity<ResponseApi> addUser(UserRequestModel param);

    ResponseEntity<ResponseApi> deleteUser(Integer userId);

    ResponseEntity<ResponseApi> updateUser(UserRequestModel param);
}
