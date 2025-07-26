package com.code.music_catalog_service.songs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.common_vo.utils.ApiResponse;
import com.code.music_catalog_service.album.entity.AlbumVO;
import com.code.music_catalog_service.album.repository.AlbumRepository;
import com.code.music_catalog_service.artist.entity.ArtistVO;
import com.code.music_catalog_service.artist.repository.ArtistRepository;
import com.code.music_catalog_service.songs.dto.request.StoreSongDTO;
import com.code.music_catalog_service.songs.entity.SongVO;
import com.code.music_catalog_service.songs.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private ArtistRepository artistRepo;

    @Autowired
    private SongRepository songRepo;

    @Override
    public ApiResponse storeSong(StoreSongDTO dto) {

        AlbumVO album = albumRepo.findById(dto.getAlbum_id()).get();
        ArtistVO artist = artistRepo.findById(dto.getArtist_id()).get();
        SongVO newSong = SongVO.builder()
                .album(album)
                .name(dto.getName())
                .artist(artist)
                .build();

        SongVO newSongSaved = songRepo.save(newSong);

        return new ApiResponse(true, "New Song Has Been Created", newSongSaved);
    }

    @Override
    public void getSongs() {

    }

}
