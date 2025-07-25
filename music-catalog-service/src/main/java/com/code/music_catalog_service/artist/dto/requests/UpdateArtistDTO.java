package com.code.music_catalog_service.artist.dto.requests;

import com.code.music_catalog_service.shared.validation.artistIdExist.ArtistIdExist;
import com.code.music_catalog_service.shared.validation.artistNameExist.ArtistNameExist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateArtistDTO {

    @ArtistIdExist
    private Long artist_id;

    @ArtistNameExist
    private String name;

    private Integer age;

    private String nationality;
}
