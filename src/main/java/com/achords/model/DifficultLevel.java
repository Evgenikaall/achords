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
@NoArgsConstructor
@AllArgsConstructor
public class DifficultLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer difficultId;

    private String difficultName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "difficultLevel")
    private List<Song> songListFilteredByDifficult = new ArrayList<>();
}
