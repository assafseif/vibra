package com.code.music_catalog_service.shared.validation.artistIdExist;

import org.springframework.beans.factory.annotation.Autowired;

import com.code.music_catalog_service.artist.repository.ArtistRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ArtistIdExistValidator implements ConstraintValidator<ArtistIdExist, Long> {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return this.artistRepository.existsById(id);
    }
}
