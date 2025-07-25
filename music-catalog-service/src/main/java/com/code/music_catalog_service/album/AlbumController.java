package com.code.music_catalog_service.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.music_catalog_service.album.dto.requests.StoreAlbumDTO;
import com.code.music_catalog_service.album.dto.requests.UpdateAlbumDTO;
import com.code.music_catalog_service.album.service.AlbumService;
import com.code.common_vo.utils.ApiResponse;


import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> storeAlbum(@Valid @RequestBody StoreAlbumDTO dto) {
        return ResponseEntity.ok(albumService.storeAlbum(dto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateAlbum(@Valid @RequestBody UpdateAlbumDTO dto) {
        return ResponseEntity.ok(albumService.updateAlbum(dto));
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponse> listAlbums() {
        return ResponseEntity.ok(albumService.listAlbums());
    }

    @PostMapping("/get")
    public ResponseEntity<ApiResponse> getAlbumById() {
        return ResponseEntity.ok(albumService.getAlbumById());
    }

    @PostMapping("/delete/{album_id}")
    public ResponseEntity<ApiResponse> deleteAlbum() {
        return ResponseEntity.ok(albumService.deleteAlbum());
    }
}
