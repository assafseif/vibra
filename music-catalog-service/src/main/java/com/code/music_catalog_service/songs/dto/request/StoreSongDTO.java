package com.code.music_catalog_service.songs.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoreSongDTO {
    @NotNull
    private String name;

    private Long artist_id;

    private Long album_id;

}
