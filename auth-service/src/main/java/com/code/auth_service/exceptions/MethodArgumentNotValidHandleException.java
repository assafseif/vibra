package com.code.auth_service.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.code.auth_service.global.payload.ApiResponse;

@ControllerAdvice
@Order(1)
public class MethodArgumentNotValidHandleException {

    @Autowired
    private MessageSource messageSource; // ✅ Inject MessageSource

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = new ArrayList<>();

        Locale currentLocale = LocaleContextHolder.getLocale(); // ✅ Get user locale

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            Map<String, String> fieldError = new HashMap<>();
            String resolvedMessage = messageSource.getMessage(error, currentLocale);

            fieldError.put("field", error.getField());
            fieldError.put("default_message", resolvedMessage);

            errors.add(fieldError);
        });

        String globalMessage = messageSource.getMessage("validation.error", null, "Validation failed", currentLocale);

        return ResponseEntity.ok(new ApiResponse(false, globalMessage, errors));
    }
}
