package com.code.music_catalog_service.shared.validation.artistNameExist;

import org.springframework.beans.factory.annotation.Autowired;

import com.code.music_catalog_service.artist.repository.ArtistRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ArtistNameExistValidator implements ConstraintValidator<ArtistNameExist, String> {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        return !this.artistRepository.existsByName(name);
    }

}
