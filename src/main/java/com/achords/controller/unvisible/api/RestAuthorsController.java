package com.achords.controller.unvisible.api;

import com.achords.model.dto.AuthorDTO;
import com.achords.model.entity.Author;
import com.achords.service.AuthorService;
import com.achords.utils.exceptions.AuthorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/authors")
@RequiredArgsConstructor
public class RestAuthorsController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<Set<AuthorDTO>> getAll() {
        try{
            return ResponseEntity.ok(authorService.getAll());
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(authorService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        try {
            return ResponseEntity.ok(authorService.save(author));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAuthor(@RequestBody AuthorDTO authorDTO){
        try{
            authorService.delete(authorDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
