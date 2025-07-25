package com.code.common_vo.exceptions;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.code.common_vo.utils.ApiResponse;


@ControllerAdvice
@Order(1)
public class MethodArgumentNotValidHandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<com.code.common_vo.utils.ApiResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(data -> {
            HashMap<String, String> error = new HashMap<>();
            error.put("field", data.getField());
            error.put("default_message", data.getDefaultMessage());
            errors.add(error);

        });

        return ResponseEntity.ok(new ApiResponse(false, null, errors));
    }

}
