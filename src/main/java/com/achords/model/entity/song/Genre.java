package com.achords.model.entity.song;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "genre", schema = "model")
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer id;

    @Column(name = "genre_name")
    private String name;

    @Column(name = "genre_img_path")
    private String imgPath;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "genreSet")
    private Set<Song> songList = new HashSet<>();
}
