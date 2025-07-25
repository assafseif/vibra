package com.code.music_catalog_service.album.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.music_catalog_service.album.entity.AlbumVO;


@Repository
public interface AlbumRepository extends JpaRepository<AlbumVO, Long> {

}
