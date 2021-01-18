package com.achords.utils.converters;

import com.achords.model.dto.*;
import com.achords.model.entity.*;
import com.achords.service.*;
import com.achords.utils.exceptions.ChordNotFoundException;
import com.achords.utils.exceptions.GenreNotFoundException;
import com.achords.utils.exceptions.LanguageNotFoundException;
import com.achords.utils.exceptions.StrummingPatterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongConverter {
    private final AuthorService authorService;
    private final ChordsService chordsService;
    private final DifficultLevelService difficultLevelService;
    private final GenresService genresService;
    private final LanguageService languageService;
    private final SectionTypeService sectionTypeService;
    private final StrummingPatternService strummingPatternService;
    private final TuningService tuningService;

    public Song mapToEntity(SongDTO songDTO) throws Exception {
        Author author = authorService.mapToEntity(songDTO.getAuthor());
        DifficultLevel difficultLevel = difficultLevelService.findByName(songDTO.getDifficultLevel().getName());
        SectionType sectionType = sectionTypeService.findByName(songDTO.getSectionType().getName());


        Tuning tuning = tuningService.findByName(songDTO.getTuning().getName());

        Set<Chords> chords = songDTO.getChords().stream()
                .map(chordsDTO -> {
                    Chords chordsTemp = null;
                    try{
                        chordsTemp = chordsService.mapToEntity(chordsDTO);
                    } catch (ChordNotFoundException e) {
                        chordsTemp = chordsService.save(chordsDTO);
                        System.out.println(chordsTemp);
                    }
                    return chordsTemp;
                })
                .collect(Collectors.toSet());
        // i'm here
        System.out.println(chords);


        Set<Genre> genre = songDTO.getGenres().stream()
                .map(genreDTO -> {
                    Genre genreTemp = null;
                    try {
                        genreTemp = genresService.findByName(genreDTO.getName());
                    } catch (GenreNotFoundException e) {
                        //log
                    }
                    return genreTemp;
                })
                .collect(Collectors.toSet());

        Set<Language> languages = songDTO.getLanguages().stream()
                .map(languageDTO -> {
                    Language languageTemp = null;
                    try {
                        languageTemp = languageService.findByName(languageDTO.getName());
                    } catch (LanguageNotFoundException e) {
                        e.printStackTrace();
                    }
                    return languageTemp;
                })
                .collect(Collectors.toSet());

        Set<StrummingPattern> strummingPatterns = songDTO.getStrummingPatterns().stream()
                .map(strummingPatternDTO -> {
                    StrummingPattern strummingPatternTemp = null;
                    try {
                        strummingPatternTemp = strummingPatternService.findByName(strummingPatternDTO.getName());
                    } catch (StrummingPatterNotFoundException e) {
                        e.printStackTrace();
                    }
                    return strummingPatternTemp;
                })
                .collect(Collectors.toSet());

        return Song.builder()
                .author(author)
                .name(songDTO.getName())
                .postDate(new Timestamp(System.currentTimeMillis()))
                .difficultLevel(difficultLevel)
                .tuning(tuning)
                .chordsSet(chords)
                .genreSet(genre)
                .languagesSet(languages)
                .sectionType(sectionType)
                .strummingPatternSet(strummingPatterns)
                .lyrics(songDTO.getLyrics())
                .build();
    }

    public SongDTO mapToDTO(Song song){
        AuthorDTO authorDTO = authorService.mapToDTO(song.getAuthor());

        DifficultLevelDTO difficultLevelDTO = difficultLevelService.mapToDTO(song.getDifficultLevel());

        SectionTypeDTO sectionTypeDTO = sectionTypeService.mapToDTO(song.getSectionType());

        TuningDTO tuningDTO = tuningService.mapToDTO(song.getTuning());

        Set<GenreDTO> genreDTO = song.getGenreSet().stream()
                .map(genresService::mapToDTO)
                .collect(Collectors.toSet());

        Set<LanguageDTO> languageDTO = song.getLanguagesSet().stream()
                .map(languageService::mapToDTO)
                .collect(Collectors.toSet());

        Set<StrummingPatternDTO> strummingPatternDTO = song.getStrummingPatternSet()
                .stream().map(strummingPatternService::mapToDTO)
                .collect(Collectors.toSet());

        Set<ChordsDTO> chordsDTO = song.getChordsSet()
                .stream().map(chordsService::mapToDTO)
                .collect(Collectors.toSet());


        return SongDTO.builder()
                .name(song.getName())
                .author(authorDTO)
                .lyrics(song.getLyrics())
                .difficultLevel(difficultLevelDTO)
                .sectionType(sectionTypeDTO)
                .tuning(tuningDTO)
                .genres(genreDTO)
                .languages(languageDTO)
                .strummingPatterns(strummingPatternDTO)
                .chords(chordsDTO)
                .build();
    }
}
