package com.achords.model.entity.song;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "chord", schema = "model")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chord_id")
    private Integer id;

    @Column(name = "chord_name")
    private String name;

    @Column(name = "chord_img_path")
    private String imgPath;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "chordsSet")
    private Set<Song> songSet = new HashSet<>();

    public Chords(Integer id,String name, String imgPath){
    }

}
