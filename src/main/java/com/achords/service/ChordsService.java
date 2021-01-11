package com.achords.service;

import com.achords.model.Chords;
import com.achords.repository.ChordsRepo;
import com.achords.utils.exceptions.ChordNotFoundException;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChordsService {

    private final ChordsRepo chordsRepo;

    public List<Chords> getAll() throws EmptyRequestBodyException {
        List<Chords> chordsList = chordsRepo.findAll();
        if(chordsList.isEmpty())
            throw new EmptyRequestBodyException();
        else
            return chordsList;
    }

    public Chords findById(String chordName) throws ChordNotFoundException {
        return chordsRepo.findById(chordName).orElseThrow(ChordNotFoundException::new);
    }


}
