package com.example.demo.restapijvs.helloworld.controller;


import com.example.demo.restapijvs.helloworld.service.HelloWorldService;
import com.example.demo.restapijvs.helloworld.model.RequestModel;
import com.example.demo.restapijvs.utils.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class HelloWorldController {
    @Autowired(required = false)
    HelloWorldService helloWorldService;

    @GetMapping("/messages")
    public ResponseEntity<ResponseApi> getMessage() {
        try {
            var result = helloWorldService.getHelloWorld();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/messages")
    public ResponseEntity<ResponseApi> createMessage(@RequestBody RequestModel request) {
        try {
            var result = helloWorldService.createHelloWorld(request);
            return new ResponseEntity<>(result, HttpStatus.OK);


        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/messages/{messagesId}")
    public ResponseEntity<ResponseApi> deleteMessage(@PathVariable Integer messagesId) {
        try {
            var result = helloWorldService.deleteHelloWorld();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
