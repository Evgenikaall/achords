package com.achords.controller.unvisible.api;

import com.achords.model.dto.ChordsDTO;
import com.achords.model.entity.Chords;
import com.achords.service.ChordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/chords")
public class RestChordsController {

    private final ChordsService chordsService;

    @GetMapping
    public ResponseEntity<Set<ChordsDTO>> getAll(){
        try{
            return ResponseEntity.ok(chordsService.getAll());
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }


    @PostMapping
    public ResponseEntity<Chords> saveChords(@RequestBody ChordsDTO chordsDTO){
        try{
            return ResponseEntity.ok(chordsService.save(chordsDTO));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

}
