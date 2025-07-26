package com.code.music_catalog_service.album.entity;

import java.util.List;

import com.code.music_catalog_service.artist.entity.ArtistVO;
import com.code.music_catalog_service.songs.entity.SongVO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_album")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    @JsonBackReference
    private ArtistVO artist;


    @OneToMany(fetch = FetchType.LAZY)
    // @JoinColumn(name = "song_id")
    private List<SongVO> song;


    // @OneToMany
    // @JoinColumn(name = "song_id")
    // private SongVO song;

}
