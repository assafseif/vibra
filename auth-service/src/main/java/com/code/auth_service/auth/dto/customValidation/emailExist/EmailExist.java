package com.code.auth_service.auth.dto.customValidation.emailExist;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailExistValidator.class)
public @interface EmailExist {

     String message() default "{email.exist}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
