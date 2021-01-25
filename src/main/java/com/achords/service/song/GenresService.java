package com.achords.service.song;

import com.achords.model.dto.song.GenreDTO;
import com.achords.model.entity.song.Genre;
import com.achords.repository.songRepo.GenresRepo;
import com.achords.utils.exceptions.GenreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenresService {

    private final GenresRepo genresRepo;

    public Set<GenreDTO> getAll() {
        return genresRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public Genre save(GenreDTO genreDTO) throws GenreNotFoundException {
        return genresRepo.save(findByName(genreDTO.getName()));
    }

    public Genre findById(Integer id) throws GenreNotFoundException {
        return genresRepo.findById(id).orElseThrow(GenreNotFoundException::new);
    }

    public Genre findByName(String name) throws GenreNotFoundException {
        return genresRepo.findByName(name).orElseThrow(GenreNotFoundException::new);
    }

    public GenreDTO mapToDTO(Genre genre){
        return GenreDTO.builder()
                .name(genre.getName())
                .imgPath(genre.getImgPath())
                .build();
    }

    public Genre mapToEntity(GenreDTO genreDTO) throws GenreNotFoundException {
        return findByName(genreDTO.getName());
    }
}
