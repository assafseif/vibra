package com.code.music_catalog_service.songs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.music_catalog_service.songs.entity.SongVO;

public interface SongRepository extends JpaRepository<SongVO,Long> {
    
}
