package com.code.music_catalog_service.songs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.common_vo.utils.ApiResponse;
import com.code.music_catalog_service.songs.dto.request.StoreSongDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/song")
public class SongController {
    
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createSong(@Valid @RequestBody StoreSongDTO dto ){
        return ResponseEntity.ok(new ApiResponse(true,"asd","assaf"));
    }


}
