package com.code.music_catalog_service.album.dto.requests;

import lombok.Data;

@Data
public class UpdateAlbumDTO {

    private String name;

    private Long artist_id;

    private Long album_id;

}
