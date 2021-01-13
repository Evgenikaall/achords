package com.achords.service;

import com.achords.model.Language;
import com.achords.repository.LanguageRepo;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import com.achords.utils.exceptions.LanguageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepo languageRepo;

    public Set<Language> getAll(){
        return new HashSet<>(languageRepo.findAll());
    }

    public Language save(Language newLanguage) throws EmptyRequestBodyException {
        if(newLanguage == null){
            throw new EmptyRequestBodyException();
        }else{
            return languageRepo.save(newLanguage);
        }
    }

    public Language findById(Integer id) throws LanguageNotFoundException {
        return languageRepo.findById(id).orElseThrow(LanguageNotFoundException::new);
    }

}
