package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "strumming_pattern")
@NoArgsConstructor
@AllArgsConstructor
public class StrummingPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer strummingPatternId;

    private String strummingPatternName;

    private String strummingPatternImgPath;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Song> songStrummingPatterns;
}
