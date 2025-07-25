package com.code.music_catalog_service.shared.validation.artistIdExist;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

@Documented
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ArtistIdExistValidator.class)
public @interface ArtistIdExist {

    String message() default "Artist ID Doesnt Exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
