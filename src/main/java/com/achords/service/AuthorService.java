package com.achords.service;

import com.achords.model.dto.AuthorDTO;
import com.achords.model.entity.Author;
import com.achords.repository.AuthorRepo;
import com.achords.utils.exceptions.AuthorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;

    public Author save(Author newAuthor) {
        return authorRepo.save(newAuthor);
    }

    public AuthorDTO findById(Integer id) throws AuthorNotFoundException {
        return authorRepo.findById(id).map(this::mapToDTO).orElseThrow(AuthorNotFoundException::new);
    }

    public Set<AuthorDTO> getAll() {
        return authorRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public Author findByName(String name) throws AuthorNotFoundException {
        return authorRepo.findAuthorByName(name).orElseThrow(AuthorNotFoundException::new);
    }

    public void delete(AuthorDTO authorDTO) throws AuthorNotFoundException {
        authorRepo.delete(findByName(authorDTO.getName()));
    }

    public AuthorDTO mapToDTO(Author author) {
        return AuthorDTO.builder()
                .name(author.getName())
                .imgPath(author.getImgPath())
                .build();
    }

    public Author mapToEntity(AuthorDTO authorDTO) throws AuthorNotFoundException {
        return findByName(authorDTO.getName());
    }
}
