package com.achords.service;

import com.achords.model.dto.SongDTO;
import com.achords.model.entity.Genre;
import com.achords.model.entity.Language;
import com.achords.model.entity.Song;
import com.achords.model.entity.StrummingPattern;
import com.achords.repository.SongRepo;
import com.achords.utils.converters.SongConverter;
import com.achords.utils.exceptions.SongNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return songRepo.findAll().stream().map(songConverter::mapToDTO).collect(Collectors.toList());
    }

    public Song findSongById(Integer id) throws SongNotFoundException {
        return songRepo.findById(id).orElseThrow(SongNotFoundException::new);
    }


}
