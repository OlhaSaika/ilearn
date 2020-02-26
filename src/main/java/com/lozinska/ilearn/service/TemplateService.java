package com.lozinska.ilearn.service;

import com.lozinska.ilearn.entity.Word;

import java.util.Set;

public interface TemplateService {
    Set<Word> generateTemplate(Integer startNumber, Integer capacity);

    Set<Word> generateRandomTemplate(Integer capacity);
}
