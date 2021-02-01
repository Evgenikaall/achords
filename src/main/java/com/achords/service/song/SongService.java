package com.achords.service.song;

import com.achords.model.dto.song.AuthorDTO;
import com.achords.model.dto.song.SongDTO;
import com.achords.model.entity.song.Author;
import com.achords.model.entity.song.Genre;
import com.achords.model.entity.song.Song;
import com.achords.repository.songRepo.SongRepo;
import com.achords.utils.converters.SongConverter;
import com.achords.utils.exceptions.SongNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepo songRepo;
    private final SongConverter songConverter;


    public Song save(Song newSong) {
        return songRepo.save(newSong);
    }

    public void delete(Song currentSong) {
        songRepo.delete(currentSong);
    }

    public List<SongDTO> getAll() {
        return StreamSupport.stream(songRepo.findAll().spliterator(), false)
                .map(songConverter::mapToDTO)
                .collect(Collectors.toList());
    }


    public Song findSongById(Integer id) throws SongNotFoundException {
        return songRepo.findById(id).orElseThrow(SongNotFoundException::new);
    }


}
