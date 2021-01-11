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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Chords> chordsList = new ArrayList<>();
        List<Genre> genreList = new ArrayList<>();
        List<Language> languageList = new ArrayList<>();
        List<StrummingPattern> strummingPatternList = new ArrayList<>();

        try{
            difficultLevel = difficultLevelService.findById(songRequest.getDifficultLevel().getDifficultId());
            difficultLevel.getSongList().add(songRequest);
        } catch (DifficultLevelNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try {
            author = authorService.getAuthorById(songRequest.getAuthor().getId());
            author.getSongList().add(songRequest);
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try {
            for (Genre genre : songRequest.getGenreList()){
                Genre tempGenre = genresService.findById(genre.getGenreId());
                genreList.add(tempGenre);
                tempGenre.getSongGenres().add(songRequest);
            }
        } catch (GenreNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try{
            for(Language language : songRequest.getLanguagesList()){
                Language tempLanguage = languageService.findById(language.getLanguageId());
                languageList.add(tempLanguage);
                tempLanguage.getSongLanguages().add(songRequest);
            }
        } catch (LanguageNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try{
            for(StrummingPattern strummingPattern : songRequest.getStrummingPatternList()){
                StrummingPattern tempStrummingPattern = strummingPatternService.findById(strummingPattern.getStrummingPatternId());
                strummingPatternList.add(tempStrummingPattern);
                tempStrummingPattern.getSongStrummingPatterns().add(songRequest);
            }
        } catch (StrummingPatterNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try{
            tuning = tuningService.findById(songRequest.getSongTuning().getTuning());
            tuning.getSongList().add(songRequest);
        } catch (TuningNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        try{
            chordsList.add(chordsService.findById("Am"));
            chordsService.findById("Am").getSongChords().add(songRequest);
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
                .chordsList(chordsList)
                .genreList(genreList)
                .languagesList(languageList)
                .strummingPatternList(strummingPatternList)
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
