package com.code.music_catalog_service.songs.entity;

import com.code.music_catalog_service.album.entity.AlbumVO;
import com.code.music_catalog_service.artist.entity.ArtistVO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "t_Song")
@Builder
public class SongVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistVO artist;


    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumVO album;

}
