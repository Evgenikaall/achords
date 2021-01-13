package com.achords.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "difficult_level")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DifficultLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "difficult_level_id")
    private Integer difficultLevelId;

    @Column(name = "difficult_level_name")
    private String difficultLevelName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "difficultLevel", cascade = CascadeType.ALL)
    private Set<Song> songListByDifficultLevel = new HashSet<>();
}
