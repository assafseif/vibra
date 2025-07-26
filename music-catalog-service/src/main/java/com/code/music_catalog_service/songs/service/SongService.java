package com.code.music_catalog_service.songs.service;

import com.code.common_vo.utils.ApiResponse;
import com.code.music_catalog_service.songs.dto.request.StoreSongDTO;

public interface SongService {
    
    ApiResponse storeSong(StoreSongDTO dto );

    void getSongs();
}
