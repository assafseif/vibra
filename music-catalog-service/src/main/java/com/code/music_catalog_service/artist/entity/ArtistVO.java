package com.code.music_catalog_service.artist.entity;

import java.util.List;

import com.code.music_catalog_service.album.entity.AlbumVO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_artist")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtistVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String nationality;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<AlbumVO> albums;

}
