package com.example.demo.restapijvs.user.controller;

import com.example.demo.restapijvs.user.model.UserRequestModel;
import com.example.demo.restapijvs.user.service.UserService;
import com.example.demo.restapijvs.utils.Headers;
import com.example.demo.restapijvs.utils.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class UserController {
    @Autowired(required = false)
    UserService userService;

    @GetMapping("/v1/users")
    public ResponseEntity<ResponseApi> getUsers() {
        log.info(" --- [LOG] GET/v1/users is called");
        var result = userService.getUsers();
        return result;
    }

    @GetMapping("/v1/users/{userId}")
    public ResponseEntity<ResponseApi> getUserById(@PathVariable Integer userId) {
        log.info(" --- [LOG] GET/v1/users/{userId} is called");
        var result = userService.getUserById(userId);
        return result;
    }

    @PostMapping("/v1/users")
    public ResponseEntity<ResponseApi> addUser(@RequestBody UserRequestModel request) {
        log.info(" --- [LOG] POST/v1/users is called");
        var result = userService.addUser(request);
        return result;
    }

    @DeleteMapping("/v1/users/{userId}")
    public ResponseEntity<ResponseApi> deleteUser(@PathVariable Integer userId) {
        log.info(" --- [LOG] DELETE/v1/users/{userId} is called");
        var result = userService.deleteUser(userId);
        return result;
    }

    @PutMapping("/v1/users")
    public ResponseEntity<ResponseApi> updateUser(@RequestBody UserRequestModel request) {
        log.info(" --- [LOG] PUT/v1/users is called");
        var result = userService.updateUser(request);
        return result;
    }
}
