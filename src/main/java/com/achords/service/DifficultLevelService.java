package com.achords.service;

import com.achords.model.DifficultLevel;
import com.achords.repository.DifficultLevelRepo;
import com.achords.utils.exceptions.DifficultLevelNotFoundException;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DifficultLevelService {

    private final DifficultLevelRepo difficultLevelRepo;

    public DifficultLevel save(DifficultLevel newDifficultLevel) throws EmptyRequestBodyException {
        if(newDifficultLevel == null)
            throw new EmptyRequestBodyException();
        else
            return difficultLevelRepo.save(newDifficultLevel);
    }

    public List<DifficultLevel> getAll(){
        return difficultLevelRepo.findAll();
    }

    public DifficultLevel findById(Integer id) throws DifficultLevelNotFoundException {
        return difficultLevelRepo.findById(id).orElseThrow(DifficultLevelNotFoundException::new);
    }

    public void delete(DifficultLevel difficultLevel) throws DifficultLevelNotFoundException {
        if(difficultLevel == null)
            throw new DifficultLevelNotFoundException();
        else
            difficultLevelRepo.delete(difficultLevel);
    }
}
