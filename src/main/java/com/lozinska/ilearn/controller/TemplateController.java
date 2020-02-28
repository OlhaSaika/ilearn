package com.lozinska.ilearn.controller;

import com.lozinska.ilearn.dto.TemplateParamsDTO;
import com.lozinska.ilearn.entity.Template;
import com.lozinska.ilearn.entity.Word;
import com.lozinska.ilearn.service.TemplateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/template")
public class TemplateController {
    private final TemplateService templateService;

    @GetMapping
    public ResponseEntity<Set<Word>> generateTemplate(@RequestBody TemplateParamsDTO params){
        Set<Word> result = new LinkedHashSet<>();
        if (params.getStartNumber()!=null){
           result = templateService.generateTemplate(params.getStartNumber(), params.getCapacity());
        }else {
            result = templateService.generateRandomTemplate(params.getCapacity());
        }
        return ResponseEntity.ok(result);
    }

}
