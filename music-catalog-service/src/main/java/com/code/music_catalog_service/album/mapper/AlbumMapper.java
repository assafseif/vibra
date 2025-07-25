package com.code.music_catalog_service.album.mapper;

import com.code.music_catalog_service.album.dto.requests.UpdateAlbumDTO;
import com.code.music_catalog_service.album.entity.AlbumVO;
import com.code.music_catalog_service.album.mapper.helper.ArtistMapperHelper;

import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    uses = ArtistMapperHelper.class,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AlbumMapper {

    @Mapping(target = "artist", source = "artist_id", qualifiedByName = "mapArtistIdToArtist")
    void updateAlbumFromDto(UpdateAlbumDTO dto, @MappingTarget AlbumVO album);
}
