package com.achords.service;

import com.achords.model.Tuning;
import com.achords.repository.TuningRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TuningService {

    private final TuningRepo tuningRepo;

    public List<Tuning> getAll(){
        return tuningRepo.findAll();
    }

}
