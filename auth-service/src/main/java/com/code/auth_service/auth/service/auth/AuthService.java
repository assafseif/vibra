package com.code.auth_service.auth.service.auth;

import com.code.auth_service.auth.dto.request.LoginDTO;
import com.code.auth_service.auth.dto.request.RegisterDTO;
import com.code.auth_service.global.payload.ApiResponse;

public interface AuthService {
    ApiResponse login(LoginDTO dto);

    ApiResponse register(RegisterDTO dto);

}
