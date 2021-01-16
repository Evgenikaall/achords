package com.achords.controller.unvisible.api;

import com.achords.model.dto.TuningDTO;
import com.achords.model.entity.Tuning;
import com.achords.service.TuningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/tuning")
@RequiredArgsConstructor
public class RestTuningController {

    private final TuningService tuningService;

    @GetMapping
    public ResponseEntity<Set<TuningDTO>> getAll(){
        try{
            return ResponseEntity.ok(tuningService.getAll());
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

}
