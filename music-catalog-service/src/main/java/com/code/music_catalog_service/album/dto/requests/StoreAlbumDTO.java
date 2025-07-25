package com.code.music_catalog_service.album.dto.requests;

import com.code.music_catalog_service.shared.validation.artistIdExist.ArtistIdExist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NotNull
public class StoreAlbumDTO {

    @NotBlank
    private String name;

    @ArtistIdExist
    private Long artist_id;

}
