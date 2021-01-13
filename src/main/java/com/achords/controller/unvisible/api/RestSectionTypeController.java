package com.achords.controller.unvisible.api;

import com.achords.model.SectionType;
import com.achords.service.SectionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/section_type")
public class RestSectionTypeController {

    private final SectionTypeService sectionTypeService;


    @GetMapping
    public ResponseEntity<Set<SectionType>> getAll(){
        Set<SectionType> sectionTypeList = sectionTypeService.getAll();
        if(sectionTypeList.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(sectionTypeList);
    }


}
