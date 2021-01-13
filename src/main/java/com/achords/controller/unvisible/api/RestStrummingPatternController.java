package com.achords.controller.unvisible.api;

import com.achords.model.StrummingPattern;
import com.achords.service.StrummingPatternService;
import com.achords.utils.exceptions.EmptyRequestBodyException;
import com.achords.utils.exceptions.StrummingPatterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/strumming_pattern")
@RequiredArgsConstructor
public class RestStrummingPatternController {

    private final StrummingPatternService strummingPatternService;

    @GetMapping
    public ResponseEntity<Set<StrummingPattern>> getAll(){
        Set<StrummingPattern> strummingPatternList = strummingPatternService.getAll();
        if(strummingPatternList.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(strummingPatternList);
    }

    @PostMapping
    public ResponseEntity<StrummingPattern> saveNewPattern(@RequestBody StrummingPattern strummingPattern){
        try {
            return ResponseEntity.ok(strummingPatternService.save(strummingPattern));
        } catch (EmptyRequestBodyException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody StrummingPattern strummingPattern){
        try{
            strummingPatternService.delete(strummingPattern);
            return ResponseEntity.ok().build();
        } catch (StrummingPatterNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
