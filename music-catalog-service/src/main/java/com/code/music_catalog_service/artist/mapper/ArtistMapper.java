package com.code.music_catalog_service.artist.mapper;

import org.mapstruct.*;
import com.code.music_catalog_service.artist.dto.requests.UpdateArtistDTO;
import com.code.music_catalog_service.artist.entity.ArtistVO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArtistMapper {

    void updateArtistFromDto(UpdateArtistDTO dto, @MappingTarget ArtistVO artist);
}