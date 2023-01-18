package com.example.demo.restapijvs.user.adapter.controller;

import com.example.demo.restapijvs.user.config.JwtUtils;
import com.example.demo.restapijvs.user.model.AuthenticationRequest;
import com.example.demo.restapijvs.user.model.AuthenticationResponse;
import com.example.demo.restapijvs.user.model.UserDao;
import com.example.demo.restapijvs.utils.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/auth")
public class AuthenticateController {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;
    private final ResponseApi responseApi;

//    @PostMapping("/authenticate")
//    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//        );
//        final UserDetails user = userDao.findUserByEmail(request.getEmail());
//        if (user != null){
//            return ResponseEntity.ok(jwtUtils.generateToken(user));
//        }
//
//        return ResponseEntity.badRequest().body("Some error has occurred");
//    }

    @PostMapping("/login")
    public ResponseEntity<ResponseApi> authenticate(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getPhone(), request.getPassword())
        );
        final UserDetails user = userDao.findByPhone(request.getPhone());
        if (user != null){
            var data = new AuthenticationResponse(jwtUtils.generateToken(user));
            return new ResponseEntity<>(responseApi.HttpStatusOK("Success authentication", data), HttpStatus.OK);
        }
        return new ResponseEntity<>(responseApi.BadRequest("Invalid phone and password"), HttpStatus.BAD_REQUEST);
    }
}
