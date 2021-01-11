package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "difficult_level")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DifficultLevel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer difficultId;

    private String difficultName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "difficultLevel")
    private List<Song> songList;
}
