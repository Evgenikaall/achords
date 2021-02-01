package com.achords.controller.unvisible.api;

import com.achords.model.dto.song.DifficultLevelDTO;
import com.achords.service.song.DifficultLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/difficult_level")
public class RestDifficultLevelController {

    private final DifficultLevelService difficultLevelService;

    @GetMapping
    public ResponseEntity<Set<DifficultLevelDTO>> getAll() {
        try {
            return ResponseEntity.ok(difficultLevelService.getAll());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody DifficultLevelDTO difficultLevelDTO) {
        try {
            difficultLevelService.delete(difficultLevelDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
