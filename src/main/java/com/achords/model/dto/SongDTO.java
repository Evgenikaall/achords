package com.achords.model.dto;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongDTO {
    private String name;
    private AuthorDTO author;
    private TuningDTO tuning;
    private DifficultLevelDTO difficultLevel;
    private SectionTypeDTO sectionType;
    private Set<GenreDTO> genres;
    private Set<LanguageDTO> languages;
    private Set<StrummingPatternDTO> strummingPatterns;
    private Set<ChordsDTO> chords;
    private String lyrics;
    private String comments;

}
