package com.achords.controller.unvisible.api;

import com.achords.model.dto.song.GenreDTO;
import com.achords.model.entity.song.Genre;
import com.achords.service.song.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/genres")
public class RestGenresController {

    private final GenresService genresService;

    @GetMapping
    public ResponseEntity<Set<GenreDTO>> getAll() {
        try {
            return ResponseEntity.ok(genresService.getAll());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Genre> save(@RequestBody GenreDTO genreDTO) {
        try {
            return ResponseEntity.ok(genresService.save(genreDTO));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

}
