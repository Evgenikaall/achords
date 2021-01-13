package com.achords.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@Table(name = "chord")
@NoArgsConstructor
@AllArgsConstructor
public class Chords {

    @Id
    @Column(name = "chord_name")
    private String chordName;

    @Column(name = "chord_img_path")
    private String chordImgPath;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "chordsSet")
    private Set<Song> songSetByChords = new HashSet<>();

}
