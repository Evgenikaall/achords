package com.achords.controller.unvisible.api;

import com.achords.model.dto.SongDTO;
import com.achords.model.entity.Song;
import com.achords.service.*;
import com.achords.utils.converters.SongConverter;
import com.achords.utils.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/songs")
public class RestSongsController {

    private final SongService songService;
    private final SongConverter songConverter;

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAll() {
        try{
            return ResponseEntity.ok(songService.getAll());
        }catch (Exception e){
            return  ResponseEntity.noContent().build();
        }
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<SongDTO> getSongById(@PathVariable Integer id) {
//        try {
//            return ResponseEntity.ok();
//        } catch (SongNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping
    public ResponseEntity<Song> saveNewSong(@RequestBody SongDTO songRequest) {
        try {
            Song song = songConverter.mapToEntity(songRequest);
            System.out.println(song);
            songService.save(song);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping
    public ResponseEntity<?> deleteSong(@RequestBody Song song) {
        try {
            songService.delete(song);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
