package com.code.music_catalog_service.album.mapper.helper;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.code.music_catalog_service.artist.entity.ArtistVO;
import com.code.music_catalog_service.artist.repository.ArtistRepository;

import jakarta.ws.rs.NotFoundException;

@Component
public class ArtistMapperHelper {

    @Autowired
    private ArtistRepository artistRepository;

    @Named("mapArtistIdToArtist")
    public ArtistVO mapArtistIdToArtist(Long artistId) {
        if (artistId == null)
            return null;
        return artistRepository.findById(artistId)
                .orElseThrow(() -> new NotFoundException("Artist not found with id: " + artistId));
    }
}