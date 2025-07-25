package com.code.auth_service.exceptions;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.code.auth_service.global.payload.ApiResponse;


@ControllerAdvice
@Order(2)
public class handleGlobalException {
    
      @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalException(Exception ex, WebRequest request) {
        return ResponseEntity.ok(new ApiResponse(false,ex.getMessage(), null));
                
    }
}
