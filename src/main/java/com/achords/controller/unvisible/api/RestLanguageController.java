package com.achords.controller.unvisible.api;

import com.achords.model.Language;
import com.achords.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/language")
public class RestLanguageController {

    private final LanguageService languageService;

    @GetMapping
    public ResponseEntity<Set<Language>> getAll(){
        Set<Language> languageList = languageService.getAll();
        if(languageList.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(languageList);
    }

}
