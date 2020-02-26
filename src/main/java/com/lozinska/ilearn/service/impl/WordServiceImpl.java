package com.lozinska.ilearn.service.impl;

import com.lozinska.ilearn.repository.WordRepository;
import com.lozinska.ilearn.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;


}
