package com.achords.controller.unvisible.api;

import com.achords.model.dto.song.LanguageDTO;
import com.achords.service.song.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/language")
public class RestLanguageController {

    private final LanguageService languageService;

    @GetMapping
    public ResponseEntity<Set<LanguageDTO>> getAll(){
        try{
            return ResponseEntity.ok(languageService.getAll());
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

}
