package com.code.api_gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.api_gateway.global.payload.ApiResponse;

@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public ResponseEntity<ApiResponse> fallback() {

        return ResponseEntity
                .ok(new ApiResponse(false, "Service is temporarily unavailable. Please try again later.", null));

    }
}
