package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.web.servlet.tags.form.TextareaTag;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@Table(name = "song")
@NoArgsConstructor
@AllArgsConstructor
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;

    private String songName;

    private Date postDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(updatable = false, insertable = false)
    private DifficultLevel difficultLevel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(updatable = false, insertable = false)
    private Tuning songTuning;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(insertable = false, updatable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(insertable = false, updatable = false)
    private SectionType sectionType;

    @ManyToMany(mappedBy = "songChords")
    private List<Chords> chordsList;

    @ManyToMany(mappedBy = "songGenres")
    private List<Genre> genreList;

    @ManyToMany(mappedBy = "songLanguages")
    private List<Language> languagesList;

    @ManyToMany(mappedBy = "songStrummingPatterns")
    private List<StrummingPattern> strummingPatternList;

    @Lob
    @Type(type = "text")
    private String songLyrics;

    //text song
    // difficult get by id
}
