package com.achords.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "chord")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chords {

    @Id
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
