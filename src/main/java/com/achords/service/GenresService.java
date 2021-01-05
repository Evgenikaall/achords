package com.achords.service;

import com.achords.model.Genre;
import com.achords.repository.GenresRepo;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenresService {

    private final GenresRepo genresRepo;

    public List<Genre> getAll(){
        return genresRepo.findAll();
    }

    public Genre save(Genre genre) throws EmptyRequestBodyException {
        if(genre == null)
            throw new EmptyRequestBodyException();
        else
            return genresRepo.save(genre);
    }
}
