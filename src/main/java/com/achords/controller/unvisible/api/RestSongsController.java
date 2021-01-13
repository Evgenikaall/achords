package com.achords.controller.unvisible.api;

import com.achords.model.*;
import com.achords.service.*;
import com.achords.utils.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/songs")
public class RestSongsController {

    private final SongService songService;
    private final DifficultLevelService difficultLevelService;
    private final AuthorService authorService;
    private final GenresService genresService;
    private final LanguageService languageService;
    private final StrummingPatternService strummingPatternService;
    private final TuningService tuningService;
    private final ChordsService chordsService;
    private final SectionTypeService sectionTypeService;

    @GetMapping
    public ResponseEntity<List<Song>> getAll() {
        List<Song> songList = songService.getAll();
        if(songList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(songService.findSongById(id));
        }catch (SongNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Song> updateSong(@RequestBody Song song){
        try{
            return ResponseEntity.ok(songService.update(song));
        } catch (EmptyRequestBodyException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Song> saveNewSong(@RequestBody Song songRequest){
        System.out.println(songRequest);
        DifficultLevel difficultLevel;
        Author author;
        Tuning tuning;
        SectionType sectionType;
        Set<Chords> chordsSet = new HashSet<>();
        Set<Genre> genreSet = new HashSet<>();
        Set<Language> languageSet = new HashSet<>();
        Set<StrummingPattern> strummingPatternSet = new HashSet<>();

        System.out.println(songRequest);

        try{
            difficultLevel = difficultLevelService.findById(songRequest.getDifficultLevel().getDifficultLevelId());
            difficultLevel.getSongListByDifficultLevel().add(songRequest);
        } catch (DifficultLevelNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try {
            author = authorService.getAuthorById(songRequest.getAuthor().getAuthorId());
            author.getSongListByAuthor().add(songRequest);
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try {
            for (Genre genre : songRequest.getGenreSet()){
                Genre tempGenre = genresService.findById(genre.getGenreId());
                genreSet.add(tempGenre);
                tempGenre.getSongListByGenres().add(songRequest);
            }
        } catch (GenreNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try{
            for(Language language : songRequest.getLanguagesSet()){
                Language tempLanguage = languageService.findById(language.getLanguageId());
                languageSet.add(tempLanguage);
                tempLanguage.getSongListByLanguages().add(songRequest);
            }
        } catch (LanguageNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try{
            for(StrummingPattern strummingPattern : songRequest.getStrummingPatternSet()){
                StrummingPattern tempStrummingPattern = strummingPatternService.findById(strummingPattern.getStrummingPatternId());
                strummingPatternSet.add(tempStrummingPattern);
                tempStrummingPattern.getSongStrummingPatterns().add(songRequest);
            }
        } catch (StrummingPatterNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try{
            tuning = tuningService.findById(songRequest.getSongTuning().getTuning());
            tuning.getSongListByTuning().add(songRequest);
        } catch (TuningNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try {
            sectionType = sectionTypeService.findById(songRequest.getSectionType().getSectionTypeId());
            sectionType.getSongListBySectionType().add(songRequest);
        } catch (SectionTypeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try{
            chordsSet.add(chordsService.findById("Am"));
            chordsService.findById("Am").getSongSetByChords().add(songRequest);
//            for (Chords chord : songRequest.getChordsList()){
//                Chords tempChord = chordsService.findById(chord.getChordName());
//                chordsList.add(tempChord);
//                tempChord.getSongChords().add(songRequest);
//                System.out.println(tempChord);
//            }
        } catch (ChordNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        Song song = Song.builder()
                .songName(songRequest.getSongName())
                .postDate(new Timestamp(System.currentTimeMillis()))
                .difficultLevel(difficultLevel)
                .songTuning(tuning)
                .author(author)
                .sectionType(songRequest.getSectionType())
                .songLyrics(songRequest.getSongLyrics())
                .chordsSet(chordsSet)
                .genreSet(genreSet)
                .languagesSet(languageSet)
                .strummingPatternSet(strummingPatternSet)
                .build();

        System.out.println(song);

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(songService.save(song));
        }catch (EmptyRequestBodyException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteSong(@RequestBody Song song){
        try{
            songService.delete(song);
            return ResponseEntity.ok().build();
        }catch (SongNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
