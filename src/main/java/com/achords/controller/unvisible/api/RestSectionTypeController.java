package com.achords.controller.unvisible.api;

import com.achords.model.dto.song.SectionTypeDTO;
import com.achords.service.song.SectionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/section_type")
public class RestSectionTypeController {

    private final SectionTypeService sectionTypeService;

    @GetMapping
    public ResponseEntity<Set<SectionTypeDTO>> getAll(){
       try {
           return ResponseEntity.ok(sectionTypeService.getAll());
       }catch (Exception e){
           return ResponseEntity.noContent().build();
       }
    }


}
