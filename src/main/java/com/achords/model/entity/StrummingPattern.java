package com.achords.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "strumming_pattern")
@NoArgsConstructor
@AllArgsConstructor
public class StrummingPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "strumming_pattern_id")
    private Integer id;

    @Column(name = "strumming_pattern_name")
    private String name;

    @Column(name = "strumming_pattern_img_path")
    private String imgPath;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "strummingPatternSet")
    private Set<Song> songList = new HashSet<>();
}
