package com.achords.model.entity.song;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "difficult_level", schema = "model")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DifficultLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "difficult_level_id")
    private Integer id;

    @Column(name = "difficult_level_name")
    private String name;

    @Column(name = "difficult_level_img_path")
    private String imgPath;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "difficultLevel", cascade = CascadeType.ALL)
    private Set<Song> songList = new HashSet<>();


}
