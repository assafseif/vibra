package com.code.music_catalog_service.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.music_catalog_service.artist.dto.requests.StoreArtistDTO;
import com.code.music_catalog_service.artist.dto.requests.UpdateArtistDTO;
import com.code.music_catalog_service.artist.service.ArtistService;
import com.code.common_vo.utils.ApiResponse;


import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> storeArtist(@Valid @RequestBody StoreArtistDTO dto) {
        return ResponseEntity.ok(this.artistService.storeArtist(dto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateArtist(@Valid @RequestBody UpdateArtistDTO dto) {
        return ResponseEntity.ok(this.artistService.updateArtist(dto));
    }



    @PostMapping("/list")
    public ResponseEntity<ApiResponse> FetchAllArtist(
            @PageableDefault(value = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok(this.artistService.FetchAllArtists(pageable));

    }

}
