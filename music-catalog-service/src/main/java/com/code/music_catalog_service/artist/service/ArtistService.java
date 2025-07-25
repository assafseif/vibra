package com.code.music_catalog_service.artist.service;

import org.springframework.data.domain.Pageable;

import com.code.music_catalog_service.artist.dto.requests.StoreArtistDTO;
import com.code.music_catalog_service.artist.dto.requests.UpdateArtistDTO;
import com.code.common_vo.utils.ApiResponse;


public interface ArtistService {

    ApiResponse storeArtist(StoreArtistDTO dto);

    ApiResponse FetchAllArtists(Pageable pageable);

    ApiResponse updateArtist(UpdateArtistDTO dto);

}
