package com.achords.service;

import com.achords.model.StrummingPattern;
import com.achords.repository.StrummingPatternRepo;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import com.achords.utils.exceptions.StrummingPatterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StrummingPatternService {

    private final StrummingPatternRepo strummingPatternRepo;

    public StrummingPattern save(StrummingPattern strummingPattern) throws EmptyRequestBodyException {
        if(strummingPattern == null)
            throw new EmptyRequestBodyException();
        else
            return strummingPatternRepo.save(strummingPattern);
    }

    public List<StrummingPattern> getAll(){
        return strummingPatternRepo.findAll();
    }

    public void delete(StrummingPattern strummingPattern) throws StrummingPatterNotFoundException {
        if(strummingPattern == null)
            throw new StrummingPatterNotFoundException();
        else
            strummingPatternRepo.delete(strummingPattern);
    }

}
