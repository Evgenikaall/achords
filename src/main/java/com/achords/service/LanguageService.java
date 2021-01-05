package com.achords.service;

import com.achords.model.Language;
import com.achords.repository.LanguageRepo;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepo languageRepo;

    public List<Language> getAll(){
        return languageRepo.findAll();
    }

    public Language save(Language newLanguage) throws EmptyRequestBodyException {
        if(newLanguage == null){
            throw new EmptyRequestBodyException();
        }else{
            return languageRepo.save(newLanguage);
        }
    }

}
