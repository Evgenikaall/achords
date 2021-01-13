package com.achords.controller.unvisible.api;

import com.achords.model.Tuning;
import com.achords.repository.TuningRepo;
import com.achords.service.TuningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tuning")
@RequiredArgsConstructor
public class RestTuningController {

    private final TuningService tuningService;

    @GetMapping
    public ResponseEntity<Set<Tuning>> getAll(){
        Set<Tuning> tuningList = tuningService.getAll();
        if(tuningList.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(tuningList);
    }

}
