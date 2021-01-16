package com.achords.service;

import com.achords.model.dto.LanguageDTO;
import com.achords.model.entity.Language;
import com.achords.repository.LanguageRepo;
import com.achords.utils.exceptions.LanguageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepo languageRepo;

    public Set<LanguageDTO> getAll() {
        return languageRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public Language save(Language newLanguage) {
        return languageRepo.save(newLanguage);
    }

    public Language findByName(String name) throws LanguageNotFoundException {
        return languageRepo.findByName(name).orElseThrow(LanguageNotFoundException::new);
    }

    public Language findById(Integer id) throws LanguageNotFoundException {
        return languageRepo.findById(id).orElseThrow(LanguageNotFoundException::new);
    }

    public LanguageDTO mapToDTO(Language language){
        return LanguageDTO.builder()
                .name(language.getName())
                .imgPath(language.getImgPath())
                .build();
    }

    public Language mapToEntity(LanguageDTO languageDTO) throws LanguageNotFoundException {
        return findByName(languageDTO.getName());
    }

}
