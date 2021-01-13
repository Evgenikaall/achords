package com.achords.controller.unvisible.api;

import com.achords.model.DifficultLevel;
import com.achords.service.DifficultLevelService;
import com.achords.utils.exceptions.DifficultLevelNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/difficult_level")
public class RestDifficultLevelController {

    private final DifficultLevelService difficultLevelService;

    @GetMapping
    public ResponseEntity<Set<DifficultLevel>> getAll(){

        Set<DifficultLevel> difficultLevelList = difficultLevelService.getAll();

        if(difficultLevelList.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(difficultLevelList);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody DifficultLevel difficultLevel){
        try{
            difficultLevelService.delete(difficultLevel);
            return ResponseEntity.ok().build();
        } catch (DifficultLevelNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
