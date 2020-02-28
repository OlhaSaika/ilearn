package com.lozinska.ilearn.controller;


import com.lozinska.ilearn.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/words")
public class WordController {
    private final WordService wordService;

    @PostMapping
    public void refreshWocabulary() throws IOException {
        wordService.saveWords();
    }
}
