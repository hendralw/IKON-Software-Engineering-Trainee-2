package com.example.demo.restapijvs.user.service;

import com.example.demo.restapijvs.user.entity.UserEntity;
import com.example.demo.restapijvs.user.repository.UserRepository;
import com.example.demo.restapijvs.utils.Json;
import com.example.demo.restapijvs.utils.ResponseApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public Optional<UserEntity> addUser(UserEntity param) {
        long size = userRepository.count();
        int newId = (int) size + 1;
        UserEntity newUser = new UserEntity(
                newId, param.getName(), param.getEmail(), passwordEncoder.encode(param.getPassword())
        );
        userRepository.save(newUser);
        return userRepository.findById(newId);
    }
}
