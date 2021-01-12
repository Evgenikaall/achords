package com.achords.service;

import com.achords.model.Genre;
import com.achords.repository.GenresRepo;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import com.achords.utils.exceptions.GenreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenresService {

    private final GenresRepo genresRepo;

    public Set<Genre> getAll(){
        return new HashSet<>(genresRepo.findAll());
    }

    public Genre save(Genre genre) throws EmptyRequestBodyException {
        if(genre == null)
            throw new EmptyRequestBodyException();
        else
            return genresRepo.save(genre);
    }

    public Genre findById(Integer id) throws GenreNotFoundException {
        return genresRepo.findById(id).orElseThrow(GenreNotFoundException::new);
    }
}
