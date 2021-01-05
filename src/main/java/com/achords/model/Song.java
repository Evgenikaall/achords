package com.achords.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String songName;

    private Date postDate;

    @ManyToOne
    private Tuning tuning;

    @ManyToOne
    private DifficultLevel difficultLevel;

    @ManyToOne
    private Author author;

    @ManyToOne
    private SectionType sectionType;

    @ManyToMany
    private List<Chords> chordsList = new ArrayList<>();

    @ManyToMany
    private List<Genre> genreList = new ArrayList<>();

    @ManyToMany
    private List<Language> languagesList = new ArrayList<>();

    @ManyToMany
    private List<StrummingPattern> strummingPatternList = new ArrayList<>();

}
