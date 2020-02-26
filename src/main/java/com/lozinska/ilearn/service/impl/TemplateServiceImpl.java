package com.lozinska.ilearn.service.impl;

import com.lozinska.ilearn.entity.Word;
import com.lozinska.ilearn.repository.WordRepository;
import com.lozinska.ilearn.service.TemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@AllArgsConstructor
@Service
public class TemplateServiceImpl implements TemplateService {
    private final WordRepository wordRepository;

    public Set<Word> generateTemplate(Integer startNumber, Integer capacity) {
        List<Word> wordsList = wordRepository.findAll();
        Set<Word> template = new HashSet<>();
        Integer start = startNumber;
        Integer end = startNumber + capacity;

        for (int i = start; i <= end; i++) {
            for (Word word : wordsList) {
                if (word.getId() == i) {
                    template.add(word);
                    break;
                }
            }
        }
        return template;
    }

    public Set<Word> generateRandomTemplate(Integer capacity) {
        List<Word> wordsList = wordRepository.findAll();
        Set<Word> template = new HashSet<>();
        do {
            Random rand = new Random();
            Word word = wordsList.get(rand.nextInt(wordsList.size()));
            template.add(word);
        } while (template.size() < capacity);
        return template;
    }
}
