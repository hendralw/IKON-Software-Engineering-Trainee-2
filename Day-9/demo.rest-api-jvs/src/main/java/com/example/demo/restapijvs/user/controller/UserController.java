package com.example.demo.restapijvs.user.controller;

import com.example.demo.restapijvs.user.entity.UserEntity;
import com.example.demo.restapijvs.user.model.UserModel;
import com.example.demo.restapijvs.user.service.UserServiceImpl;
import com.example.demo.restapijvs.utils.Headers;
import com.example.demo.restapijvs.utils.Json;
import com.example.demo.restapijvs.utils.ResponseApi;
import com.example.demo.restapijvs.utils.ValidationApi;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class UserController {

    @Autowired(required = false)
    UserServiceImpl userServiceImpl;
    @Autowired
    private ModelMapper modelMapper;
    ResponseApi resp;

    @GetMapping("/v1/users")
    public ResponseEntity<ResponseApi> getUsers() {
        var correlationId = new Headers().GenerateCorrelationId();
        var headers = new Headers().SetCorrelationId(correlationId);
        log.info(correlationId + " --- [LOG] GET/v1/users is called");
        try {
            log.info(correlationId + " --- [LOG] UserServiceImpl/getUsers is called");
            var result = userServiceImpl.getUsers();
            var resultJson = new Json<>().toJson(result);
            log.info(correlationId + " --- [LOG] result : " + resultJson);
            if (result != null && result.size() > 0) {
                var data = result.stream().map(x -> modelMapper.map(x, UserModel.class)).toList();
                resp = new ResponseApi<>().HttpStatusOK("Success get Data", data);
                return new ResponseEntity<>(resp, headers, HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseApi<>().DataNotFound(), headers, HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            log.error(correlationId + " --- [LOG] Error exception : " + ex);
            return new ResponseEntity<>(new ResponseApi<>().InternalServerError(ex), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/users/{userId}")
    public ResponseEntity<ResponseApi> getUserById(@PathVariable Integer userId) {
        var correlationId = new Headers().GenerateCorrelationId();
        var headers = new Headers().SetCorrelationId(correlationId);
        log.info(correlationId + " --- [LOG] GET/v1/users/{userId} is called");
        try {
            log.info(correlationId + " --- [LOG] UserServiceImpl/getUserById is called");
            var result = userServiceImpl.getUserById(userId);
            var resultJson = new Json<>().toJson(result);
            log.info(correlationId + " --- [LOG] result : " + resultJson);
            if (!result.isEmpty()) {
                var data = modelMapper.map(result, UserModel.class);
                resp = new ResponseApi<>().HttpStatusOK("Success get Data", data);
                return new ResponseEntity<>(resp, headers, HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseApi<>().DataNotFound(), headers, HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            log.error(correlationId + " --- [LOG] Error exception : " + ex);
            return new ResponseEntity<>(new ResponseApi<>().InternalServerError(ex), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/v1/users")
    public ResponseEntity<ResponseApi> addUser(@RequestBody UserEntity request) {
        var correlationId = new Headers().GenerateCorrelationId();
        var headers = new Headers().SetCorrelationId(correlationId);
        log.info(correlationId + " --- [LOG] POST/v1/users is called");
        try {
            log.info(correlationId + " --- [LOG] Validation request is called");
            var validate = new ValidationApi<>(request).Validate();
            if (!validate.equals("")) {
                log.info(correlationId + " --- [LOG] Validation went wrong : " + validate);
                return new ResponseEntity<>(new ResponseApi<>().BadRequest(validate), headers, HttpStatus.BAD_REQUEST);
            }
            log.info(correlationId + " --- [LOG] UserServiceImpl/addUser is called");
            var result = userServiceImpl.addUser(request);
            var resultJson = new Json<>().toJson(result);
            log.info(correlationId + " --- [LOG] result : " + resultJson);
            if (!result.isEmpty()) {
                var data = modelMapper.map(result, UserModel.class);
                resp = new ResponseApi<>().HttpStatusOK("Success add Data", data);
                return new ResponseEntity<>(resp, headers, HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseApi<>().DataNotFound(), headers, HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            log.error(correlationId + " --- [LOG] Error exception : " + ex);
            return new ResponseEntity<>(new ResponseApi<>().InternalServerError(ex), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
