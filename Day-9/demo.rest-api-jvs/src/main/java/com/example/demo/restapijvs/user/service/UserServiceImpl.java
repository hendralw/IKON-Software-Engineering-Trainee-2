package com.example.demo.restapijvs.user.service;

import com.example.demo.restapijvs.user.entity.UserEntity;
import com.example.demo.restapijvs.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserRepository userRepository;

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }
}
