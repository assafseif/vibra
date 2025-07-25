package com.code.music_catalog_service.artist.dto.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreArtistDTO {

    @NotBlank
    // @ArtistNameExist
    private String name;

    @NotNull()
    @Min(value = 0, message = "numericField: positive number, min 0 is required")
    private Integer age;

    @NotBlank
    private String nationality;
}
