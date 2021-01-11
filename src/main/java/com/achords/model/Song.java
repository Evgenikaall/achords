package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;

    private String songName;

    private Date postDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "difficult_level_difficult_id")
    private DifficultLevel difficultLevel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "song_tuning_tuning")
    private Tuning songTuning;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_type_section_type_id")
    private SectionType sectionType;
//
//    @ManyToMany(mappedBy = "songChords")
//    private List<Chords> chordsList;
//
//    @ManyToMany(mappedBy = "songGenres")
//    private List<Genre> genreList;
//
//    @ManyToMany(mappedBy = "songLanguages")
//    private List<Language> languagesList;
//
//    @ManyToMany(mappedBy = "songStrummingPatterns")
//    private List<StrummingPattern> strummingPatternList;

    @Lob
    @Type(type = "text")
    private String songLyrics;

}
