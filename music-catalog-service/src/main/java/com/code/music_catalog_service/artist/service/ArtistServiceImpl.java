package com.code.music_catalog_service.artist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.code.common_vo.utils.ApiResponse;
import com.code.music_catalog_service.artist.dto.requests.StoreArtistDTO;
import com.code.music_catalog_service.artist.dto.requests.UpdateArtistDTO;
import com.code.music_catalog_service.artist.entity.ArtistVO;
import com.code.music_catalog_service.artist.mapper.ArtistMapper;
import com.code.music_catalog_service.artist.repository.ArtistRepository;
import com.code.music_catalog_service.events.ArtistPlacedEvent;


@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private KafkaTemplate<String, ArtistPlacedEvent> kafkaTemplate;

    @Override
    public ApiResponse storeArtist(StoreArtistDTO dto) {
        ArtistVO newArtist = ArtistVO.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .nationality(dto.getNationality())
                .build();
        ArtistVO savedArtist = artistRepository.save(newArtist);

        // ArtistPlacedEvent artistPlacedEvent = new ArtistPlacedEvent();
        // artistPlacedEvent.setArtistNumber("123");
        // artistPlacedEvent.setEmail("dirani@outlook.com");
        // kafkaTemplate.send("music-placed", artistPlacedEvent);

        return new ApiResponse(true, "Artist saved successfully", savedArtist);
    }

    @Override
    public ApiResponse FetchAllArtists(Pageable pageable) {
        return new ApiResponse(true, "", this.artistRepository.findAll(pageable));

    }

    @Override
    public ApiResponse updateArtist(UpdateArtistDTO dto) {
        ArtistVO theArtist = this.artistRepository.findById(dto.getArtist_id()).get();

        artistMapper.updateArtistFromDto(dto, theArtist);
        ArtistVO savedArtist = artistRepository.save(theArtist);

        return new ApiResponse(false, "Updated !", savedArtist);
    }
}
