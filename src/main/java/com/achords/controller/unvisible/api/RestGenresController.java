package com.achords.controller.unvisible.api;

import com.achords.model.Genre;
import com.achords.service.GenresService;
import com.achords.utils.exceptions.EmptyRequestBodyException;
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
    public ResponseEntity<Set<Genre>> getAll(){
        Set<Genre> genresList = genresService.getAll();
        if(genresList.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(genresList);
    }

    @PostMapping
    public ResponseEntity<Genre> save(@RequestBody Genre genre){
        try{
            return ResponseEntity.ok(genresService.save(genre));
        } catch (EmptyRequestBodyException e) {
            return ResponseEntity.noContent().build();
        }
    }

}
