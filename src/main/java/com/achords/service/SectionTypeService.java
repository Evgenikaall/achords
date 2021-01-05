package com.achords.service;

import com.achords.model.SectionType;
import com.achords.repository.SectionTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionTypeService {

    private final SectionTypeRepo sectionTypeRepo;

    public List<SectionType> getAll(){
        return sectionTypeRepo.findAll();
    }
}
