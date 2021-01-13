package com.achords.service;

import com.achords.model.Tuning;
import com.achords.repository.TuningRepo;
import com.achords.utils.exceptions.TuningNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TuningService {

    private final TuningRepo tuningRepo;

    public Set<Tuning> getAll(){
        return new HashSet<>(tuningRepo.findAll());
    }

    public Tuning findById(String tuningName) throws TuningNotFoundException {
        return tuningRepo.findById(tuningName).orElseThrow(TuningNotFoundException::new);
    }

}
