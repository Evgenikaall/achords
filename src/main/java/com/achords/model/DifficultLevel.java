package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "difficult_level")
@AllArgsConstructor
@NoArgsConstructor
public class DifficultLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String difficultName;

    @OneToMany
    private List<Song> songListFilteredByDifficult = new ArrayList<>();
}
