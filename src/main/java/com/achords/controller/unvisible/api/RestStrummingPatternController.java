package com.achords.controller.unvisible.api;

import com.achords.model.dto.StrummingPatternDTO;
import com.achords.model.entity.StrummingPattern;
import com.achords.service.StrummingPatternService;
import com.achords.utils.exceptions.StrummingPatterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/strumming_pattern")
@RequiredArgsConstructor
public class RestStrummingPatternController {

    private final StrummingPatternService strummingPatternService;

    @GetMapping
    public ResponseEntity<Set<StrummingPatternDTO>> getAll(){
        try{
            return ResponseEntity.ok(strummingPatternService.getAll());
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<StrummingPattern> saveNewPattern(@RequestBody StrummingPattern strummingPattern){
        try {
            return ResponseEntity.ok(strummingPatternService.save(strummingPattern));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody StrummingPattern strummingPattern){
        try{
            strummingPatternService.delete(strummingPattern);
            return ResponseEntity.ok().build();
        } catch (StrummingPatterNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
