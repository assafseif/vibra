package com.code.music_catalog_service.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.common_vo.utils.ApiResponse;
import com.code.music_catalog_service.songs.dto.request.StoreSongDTO;
import com.code.music_catalog_service.songs.service.SongService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/song")
public class SongController {


    @Autowired
    private SongService songService;
    
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createSong(@Valid @RequestBody StoreSongDTO dto ){
        return ResponseEntity.ok(this.songService.storeSong(dto));
    }


}
