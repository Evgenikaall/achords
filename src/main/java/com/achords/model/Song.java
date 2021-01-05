package com.achords.model;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;

    private String songName;

    private Date postDate;

    @ManyToOne
    @JoinColumn(name = "tuning",insertable = false, updatable = false)
    private Tuning tuning;

    @ManyToOne
    @JoinColumn(name = "difficult_id",insertable = false, updatable = false)
    private DifficultLevel difficultLevel;

    @ManyToOne
    @JoinColumn(name = "author_id",insertable = false, updatable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "section_type_id",insertable = false, updatable = false)
    private SectionType sectionType;

    @OneToMany
    @JoinColumn(name = "chord_name",insertable = false, updatable = false)
    private List<Chords> chordsList = new ArrayList<>();

    @ManyToMany
    private List<Genre> genreList = new ArrayList<>();

    @ManyToMany
    private List<Language> languagesList = new ArrayList<>();

    @ManyToMany

    private List<StrummingPattern> strummingPatternList = new ArrayList<>();

    //text song
    // difficult get by id
}
