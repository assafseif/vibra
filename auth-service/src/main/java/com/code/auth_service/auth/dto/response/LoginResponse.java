package com.code.auth_service.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String access_token;
    private String refresh_token;

}
