package com.achords.service;

import com.achords.model.dto.TuningDTO;
import com.achords.model.entity.Tuning;
import com.achords.repository.TuningRepo;
import com.achords.utils.exceptions.TuningNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TuningService {

    private final TuningRepo tuningRepo;

    public Set<TuningDTO> getAll(){
        return tuningRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public Tuning findById(Integer id) throws TuningNotFoundException {
        return tuningRepo.findById(id).orElseThrow(TuningNotFoundException::new);
    }

    public Tuning findByName(String name) throws TuningNotFoundException {
        return tuningRepo.findByName(name).orElseThrow(TuningNotFoundException::new);
    }

    public TuningDTO mapToDTO(Tuning tuning){
        return TuningDTO.builder()
                .name(tuning.getName())
                .build();
    }

}
