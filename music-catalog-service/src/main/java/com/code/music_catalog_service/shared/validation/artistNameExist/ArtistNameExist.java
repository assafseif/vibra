package com.code.music_catalog_service.shared.validation.artistNameExist;

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
@Constraint(validatedBy = ArtistNameExistValidator.class)
public @interface ArtistNameExist {
    
    String message() default "Artist Name Exist, Choose another one!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
