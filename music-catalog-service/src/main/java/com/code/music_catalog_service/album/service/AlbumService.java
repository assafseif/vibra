package com.code.music_catalog_service.album.service;

import com.code.music_catalog_service.album.dto.requests.StoreAlbumDTO;
import com.code.music_catalog_service.album.dto.requests.UpdateAlbumDTO;
import com.code.common_vo.utils.ApiResponse;


public interface AlbumService {

    // Create a new album
    ApiResponse storeAlbum(StoreAlbumDTO dto);

    // Update an existing album
    ApiResponse updateAlbum(UpdateAlbumDTO dto);

    // Get a list of all albums
    ApiResponse listAlbums();

    // Get a specific album by ID
    ApiResponse getAlbumById();

    // Delete a specific album
    ApiResponse deleteAlbum();
}
