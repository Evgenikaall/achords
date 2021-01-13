package com.achords.service;

import com.achords.model.SectionType;
import com.achords.repository.SectionTypeRepo;
import com.achords.utils.exceptions.SectionTypeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionTypeService {

    private final SectionTypeRepo sectionTypeRepo;

    public Set<SectionType> getAll(){
        return new HashSet<>(sectionTypeRepo.findAll());
    }

    public SectionType findById(Integer id) throws SectionTypeNotFoundException {
        return sectionTypeRepo.findById(id).orElseThrow(SectionTypeNotFoundException::new);
    }
}
