package com.achords.service;

import com.achords.model.Chords;
import com.achords.repository.ChordsRepo;
import com.achords.utils.exceptions.ChordNotFoundException;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChordsService {

    private final ChordsRepo chordsRepo;

    public Set<Chords> getAll() {
        return new HashSet<>(chordsRepo.findAll());
    }

    public Chords findById(String chordName) throws ChordNotFoundException {
        return chordsRepo.findById(chordName).orElseThrow(ChordNotFoundException::new);
    }


}
