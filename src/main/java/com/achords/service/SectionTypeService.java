package com.achords.service;

import com.achords.model.dto.SectionTypeDTO;
import com.achords.model.entity.SectionType;
import com.achords.repository.SectionTypeRepo;
import com.achords.utils.exceptions.SectionTypeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionTypeService {

    private final SectionTypeRepo sectionTypeRepo;

    public Set<SectionTypeDTO> getAll(){
        return sectionTypeRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public SectionType findById(Integer id) throws SectionTypeNotFoundException {
        return sectionTypeRepo.findById(id).orElseThrow(SectionTypeNotFoundException::new);
    }

    public SectionType findByName(String name) throws SectionTypeNotFoundException {
        return sectionTypeRepo.findByName(name).orElseThrow(SectionTypeNotFoundException::new);
    }

    public SectionTypeDTO mapToDTO(SectionType sectionType){
        return SectionTypeDTO.builder()
                .name(sectionType.getName())
                .imgPath(sectionType.getImgPath())
                .build();
    }

    public SectionType mapToEntity(SectionTypeDTO sectionTypeDTO) throws SectionTypeNotFoundException {
        return findByName(sectionTypeDTO.getName());
    }
}
