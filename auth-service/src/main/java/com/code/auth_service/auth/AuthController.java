package com.code.auth_service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.auth_service.auth.dto.request.LoginDTO;
import com.code.auth_service.auth.dto.request.RegisterDTO;
import com.code.auth_service.auth.service.auth.AuthService;
import com.code.auth_service.global.payload.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authservice;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginDTO dto) {
        return ResponseEntity.ok(this.authservice.login(dto));
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody RegisterDTO dto){
        return ResponseEntity.ok(this.authservice.register(dto));
    }

}