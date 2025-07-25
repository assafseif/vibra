package com.code.common_vo.exceptions;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.code.common_vo.utils.ApiResponse;




@ControllerAdvice
@Order(2)
public class HandleGlobalException {
    
      @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalException(Exception ex, WebRequest request) {
        return ResponseEntity.ok(new ApiResponse(false,ex.getMessage(), null));
                
    }
}
