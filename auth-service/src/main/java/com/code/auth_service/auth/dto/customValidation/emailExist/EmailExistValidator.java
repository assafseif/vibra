package com.code.auth_service.auth.dto.customValidation.emailExist;

import org.springframework.beans.factory.annotation.Autowired;

import com.code.auth_service.auth.repo.AuthRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailExistValidator implements ConstraintValidator<EmailExist, String> {

    @Autowired
    private AuthRepository authrepo;


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !authrepo.existsByEmail(email);
    }

}
