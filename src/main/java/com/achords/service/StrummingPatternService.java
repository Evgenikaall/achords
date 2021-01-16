package com.achords.service;

import com.achords.model.dto.StrummingPatternDTO;
import com.achords.model.entity.StrummingPattern;
import com.achords.repository.StrummingPatternRepo;
import com.achords.utils.exceptions.StrummingPatterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StrummingPatternService {

    private final StrummingPatternRepo strummingPatternRepo;

    public StrummingPattern save(StrummingPattern strummingPattern){
            return strummingPatternRepo.save(strummingPattern);
    }

    public Set<StrummingPatternDTO> getAll(){
        return strummingPatternRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public void delete(StrummingPattern strummingPattern) throws StrummingPatterNotFoundException {
        if(strummingPattern == null)
            throw new StrummingPatterNotFoundException();
        else
            strummingPatternRepo.delete(strummingPattern);
    }

    public StrummingPattern findById(Integer id) throws StrummingPatterNotFoundException {
        return strummingPatternRepo.findById(id).orElseThrow(StrummingPatterNotFoundException::new);
    }

    public StrummingPattern findByName(String name) throws StrummingPatterNotFoundException {
        return strummingPatternRepo.findByName(name).orElseThrow(StrummingPatterNotFoundException::new);
    }

    public StrummingPatternDTO mapToDTO(StrummingPattern strummingPattern){
        return StrummingPatternDTO.builder()
                .name(strummingPattern.getName())
                .imgPath(strummingPattern.getImgPath())
                .build();
    }

}
