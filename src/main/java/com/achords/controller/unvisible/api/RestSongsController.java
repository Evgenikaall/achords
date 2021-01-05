package com.achords.controller.unvisible.api;

import com.achords.model.Song;
import com.achords.service.SongService;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import com.achords.utils.exceptions.IdSongNotFoundException;
import com.achords.utils.exceptions.SongNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/songs")
public class RestSongsController {

    private final SongService songService;

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
        }catch (IdSongNotFoundException e){
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
    public ResponseEntity<Song> saveNewSong(@RequestBody Song song){
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
