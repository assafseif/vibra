package com.code.music_catalog_service.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.music_catalog_service.artist.entity.ArtistVO;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistVO, Long> {
    Boolean existsByName(String name);

}
