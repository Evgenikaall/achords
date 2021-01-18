package com.achords.model.entity;


import lombok.*;


import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@Table(name = "song")
@ToString(exclude = {"chordsSet", "genreSet", "languagesSet", "strummingPatternSet"})
@EqualsAndHashCode(exclude = {"chordsSet", "genreSet", "languagesSet", "strummingPatternSet"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Integer id;

    @Column(name = "song_name")
    private String name;

    @Column(name = "song_post_date")
    private Date postDate;


    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "difficult_level_id")
    private DifficultLevel difficultLevel;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "tuning_id")
    private Tuning tuning;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "section_type_id")
    private SectionType sectionType;

    @ManyToMany(cascade = {MERGE, PERSIST}, fetch = EAGER)
    @JoinTable(
            name = "song_chords",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "chord_id", referencedColumnName = "chord_id")
    )
    private Set<Chords> chordsSet = new HashSet<>();

    @ManyToMany(cascade = {MERGE, PERSIST}, fetch = EAGER)
    @JoinTable(
            name = "song_genre",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    )
    private Set<Genre> genreSet = new HashSet<>();

    @ManyToMany(cascade = {MERGE, PERSIST}, fetch = EAGER)
    @JoinTable(
            name = "song_language",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    )
    private Set<Language> languagesSet = new HashSet<>();

    @ManyToMany(cascade = {MERGE, PERSIST}, fetch = EAGER)
    @JoinTable(
            name = "song_strumming_pattern",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "strumming_pattern_id", referencedColumnName = "strumming_pattern_id")
    )
    private Set<StrummingPattern> strummingPatternSet = new HashSet<>();

    @Lob
    @Column(name = "song_lyrics", length = 65535, columnDefinition = "text")
    private String lyrics;

    @Column(name = "song_comments", length = 65535, columnDefinition = "text")
    private String comments;


}
