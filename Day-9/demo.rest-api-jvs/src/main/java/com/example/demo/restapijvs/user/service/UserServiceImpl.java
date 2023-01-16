package com.example.demo.restapijvs.user.service;

import com.example.demo.restapijvs.user.entity.UserEntity;
import com.example.demo.restapijvs.user.model.UserResponseModel;
import com.example.demo.restapijvs.user.model.UserRequestModel;
import com.example.demo.restapijvs.user.repository.UserRepository;
import com.example.demo.restapijvs.utils.Headers;
import com.example.demo.restapijvs.utils.Json;
import com.example.demo.restapijvs.utils.ResponseApi;
import com.example.demo.restapijvs.utils.ValidationApi;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ResponseApi responseApi;
    @Autowired
    Json json;
    @Autowired
    Headers headers;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<ResponseApi> getUsers() {
        var correlationId = headers.GenerateCorrelationId();
        var customHeader = headers.SetCorrelationId(correlationId);
        try {
            log.info(correlationId + " --- [LOG] UserServiceImpl/getUsers is called");
            log.info(correlationId + " --- [LOG] userRepository.findAll is called");
            var result = (List<UserEntity>) userRepository.findAll();
            var resultJson = json.toJson(result);
            log.info(correlationId + " --- [LOG] Result from userRepository -> " + resultJson);
            if (result.size() > 0) {
                var data = result.stream().map(x -> modelMapper.map(x, UserResponseModel.class)).toList();
                return new ResponseEntity<>(responseApi.HttpStatusOK("Success get data", data), customHeader, HttpStatus.OK);
            }
            return new ResponseEntity<>(responseApi.DataNotFound(), customHeader, HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            log.error(correlationId + " --- [LOG] Error exception -> " + ex);
            return new ResponseEntity<>(responseApi.InternalServerError(ex), customHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseApi> getUserById(Integer userId) {
        var correlationId = new Headers().GenerateCorrelationId();
        var headers = new Headers().SetCorrelationId(correlationId);
        try {
            log.info(correlationId + " --- [LOG] UserServiceImpl/getUserById is called");
            log.info(correlationId + " --- [LOG] userRepository.findById is called");
            var result = userRepository.findById(userId);
            var resultJson = new Json<>().toJson(result);
            log.info(correlationId + " --- [LOG] result : " + resultJson);
            if (!result.isEmpty()) {
                var data = modelMapper.map(result, UserResponseModel.class);
                return new ResponseEntity<>(responseApi.HttpStatusOK("Success get Data", data), headers, HttpStatus.OK);
            }
            return new ResponseEntity<>(responseApi.DataNotFound(), headers, HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            log.error(correlationId + " --- [LOG] Error exception : " + ex);
            return new ResponseEntity<>(responseApi.InternalServerError(ex), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseApi> addUser(UserRequestModel request) {
        var correlationId = new Headers().GenerateCorrelationId();
        var headers = new Headers().SetCorrelationId(correlationId);
        try {
            log.info(correlationId + " --- [LOG] UserServiceImpl/addUser is called");
            log.info(correlationId + " --- [LOG] Validation request is called");
            var validate = new ValidationApi<>(request).Validate();
            if (!validate.equals("")) {
                log.info(correlationId + " --- [LOG] Validation went wrong : " + validate);
                return new ResponseEntity<>(responseApi.BadRequest(validate), headers, HttpStatus.BAD_REQUEST);
            }
            long size = userRepository.count();
            int newId = (int) size + 1;
            UserEntity newUser = new UserEntity(
                    newId, request.getName(), request.getEmail(), passwordEncoder.encode(request.getPassword())
            );
            userRepository.save(newUser);
            var result = userRepository.findById(newId);
            if (!result.isEmpty()) {
                var resultJson = new Json<>().toJson(result);
                log.info(correlationId + " --- [LOG] result : " + resultJson);
                var data = modelMapper.map(result, UserResponseModel.class);
                return new ResponseEntity<>(responseApi.HttpStatusOK("Success add Data", data), headers, HttpStatus.OK);
            }
            return new ResponseEntity<>(responseApi.DataNotFound(), headers, HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            log.error(correlationId + " --- [LOG] Error exception : " + ex);
            return new ResponseEntity<>(responseApi.InternalServerError(ex), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
