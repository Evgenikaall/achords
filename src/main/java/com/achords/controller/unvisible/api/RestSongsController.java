package com.achords.controller.unvisible.api;

import com.achords.model.dto.song.SongDTO;
import com.achords.model.dto.user.UserDetailsImpl;
import com.achords.model.entity.song.Song;
import com.achords.service.post.PostService;
import com.achords.service.song.SongService;
import com.achords.utils.converters.PostConverter;
import com.achords.utils.converters.SongConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/songs")
public class RestSongsController {

    private final SongService songService;
    private final SongConverter songConverter;
    private final PostService postService;
    private final PostConverter postConverter;

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAll() {
        try{
            return ResponseEntity.ok(songService.getAll());
        }catch (Exception e){
            return  ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Song> saveNewSong(@RequestBody SongDTO songRequest, @AuthenticationPrincipal UserDetailsImpl user) {
        try {
            Song song = songConverter.mapToEntity(songRequest);
            postService.save(postConverter.mapToEntity(song, user));
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
