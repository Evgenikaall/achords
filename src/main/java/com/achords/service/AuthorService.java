package com.achords.service;

import com.achords.model.Author;
import com.achords.repository.AuthorRepo;
import com.achords.utils.exceptions.AuthorNotFoundException;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;

    public Author save(Author newAuthor) throws EmptyRequestBodyException {
        if (newAuthor == null) {
            throw new EmptyRequestBodyException();
        } else {
            return authorRepo.save(newAuthor);
        }
    }

    public Author findById(Integer id) throws AuthorNotFoundException {
        return authorRepo.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

    public Author update(Author updatedAuthor) throws EmptyRequestBodyException {
        if(updatedAuthor == null) {
            throw new EmptyRequestBodyException();
        }else{
            return authorRepo.save(updatedAuthor);
        }
    }

    public List<Author> getAll() {
        return authorRepo.findAll();
    }

    public void delete(Author currentAuthor) throws AuthorNotFoundException {
        if (currentAuthor == null) {
            throw new AuthorNotFoundException();
        } else {
            authorRepo.delete(currentAuthor);
        }
    }

    public Author getAuthorById(Integer id) throws AuthorNotFoundException {
        return authorRepo.findById(id).orElseThrow(AuthorNotFoundException::new);
    }
}
