package com.achords.service;

import com.achords.model.Song;
import com.achords.repository.SongRepo;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import com.achords.utils.exceptions.IdSongNotFoundException;
import com.achords.utils.exceptions.SongNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepo songRepo;

    public Song save(Song newSong) throws EmptyRequestBodyException {
        if (newSong == null) {
            throw new EmptyRequestBodyException();
        } else {

            return songRepo.save(newSong);
        }
    }

    public Song update(Song updatedSong) throws EmptyRequestBodyException {
        if (updatedSong == null) {
            throw new EmptyRequestBodyException();
        } else {
            return songRepo.save(updatedSong);
        }
    }

    public void delete(Song currentSong) throws SongNotFoundException {
        if (currentSong == null) {
            throw new SongNotFoundException();
        } else {
            songRepo.delete(currentSong);
        }
    }

    public List<Song> getAll() {
        return songRepo.findAll();
    }

    public Song findSongById(Integer id) throws IdSongNotFoundException {
        return songRepo.findById(id).orElseThrow(IdSongNotFoundException::new);
    }


}
