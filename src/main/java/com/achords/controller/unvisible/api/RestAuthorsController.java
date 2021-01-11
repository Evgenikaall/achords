package com.achords.controller.unvisible.api;

import com.achords.model.Author;
import com.achords.service.AuthorService;
import com.achords.utils.exceptions.AuthorNotFoundException;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
@RequiredArgsConstructor
public class RestAuthorsController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        List<Author> authorList = authorService.getAll();
        if (authorList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(authorList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(authorService.getAuthorById(id));
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        try {
            return ResponseEntity.ok(authorService.save(author));
        } catch (EmptyRequestBodyException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestBody Author updatedAuthor){
        try{
            return ResponseEntity.ok(authorService.save(updatedAuthor));
        } catch (EmptyRequestBodyException e) {
            return ResponseEntity.noContent().build();
        }
    }


    @DeleteMapping
    public ResponseEntity deleteAuthor(@RequestBody Author author){
        try{
            authorService.delete(author);
            return ResponseEntity.ok().build();
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
