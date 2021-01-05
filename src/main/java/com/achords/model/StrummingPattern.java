package com.achords.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "strumming_pattern")
public class StrummingPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String strummingPatternName;

    private String strummingPatternImgPath;

    @ManyToMany
    private List<Song> songListOrderByStrummingPattern = new ArrayList<>();
}
