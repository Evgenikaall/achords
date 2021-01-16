package com.achords.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "section_type")
@NoArgsConstructor
@AllArgsConstructor
public class SectionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_type_id")
    private Integer id;

    @Column(name = "section_type_name")
    private String name;

    @Column(name = "section_type_img_path")
    private String imgPath;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "sectionType", cascade = CascadeType.ALL)
    private Set<Song> songList = new HashSet<>();
}
