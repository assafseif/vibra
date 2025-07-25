package com.code.music_catalog_service.album.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.music_catalog_service.album.dto.requests.StoreAlbumDTO;
import com.code.music_catalog_service.album.dto.requests.UpdateAlbumDTO;
import com.code.music_catalog_service.album.entity.AlbumVO;
import com.code.music_catalog_service.album.mapper.AlbumMapper;
import com.code.music_catalog_service.album.repository.AlbumRepository;
import com.code.music_catalog_service.artist.entity.ArtistVO;
import com.code.music_catalog_service.artist.repository.ArtistRepository;
import com.code.common_vo.utils.ApiResponse;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public ApiResponse storeAlbum(StoreAlbumDTO dto) {

        ArtistVO existingArtist = artistRepository.findById(dto.getArtist_id()).get();

        AlbumVO newArtist = AlbumVO.builder()
                .name(dto.getName())
                .artist(existingArtist)
                .build();

        return new ApiResponse(true, "Album created", albumRepository.save(newArtist));
    }

    @Override
    @Transactional
    public ApiResponse updateAlbum(UpdateAlbumDTO dto) {
        AlbumVO theAlbum = albumRepository.findById(dto.getAlbum_id())
                .orElseThrow(() -> new NotFoundException("Album not found"));
        albumMapper.updateAlbumFromDto(dto, theAlbum);
        AlbumVO savedAlbum = albumRepository.save(theAlbum);

        return new ApiResponse(true, "Album updated", savedAlbum);
    }

    @Override
    public ApiResponse listAlbums() {
        // Logic to list all albums
        return new ApiResponse(true, "Albums listed", albumRepository.findAll());
    }

    @Override
    public ApiResponse getAlbumById() {
        // Logic to get a specific album by ID
        return new ApiResponse(true, "Album fetched", null);
    }

    @Override
    public ApiResponse deleteAlbum() {
        // Logic to delete a specific album
        return new ApiResponse(true, "Album deleted", null);
    }
}
