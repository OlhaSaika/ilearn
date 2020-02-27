package com.lozinska.ilearn.service.impl;

import com.lozinska.ilearn.entity.Word;
import com.lozinska.ilearn.repository.WordRepository;
import com.lozinska.ilearn.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    public void saveWords() throws IOException {
        List<Word> exestingWords = wordRepository.findAll();
        Set<Word> newWords = new LinkedHashSet();

        FileReader input = new FileReader("C:\\Users\\OlgaPC\\Desktop\\Wocabulary.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine = null;

        while ((myLine = bufRead.readLine()) != null) {
            Word currentWord = new Word();
            String[] parts = myLine.split(" - ");
            currentWord.setTranscription(parts[0]);
            currentWord.setHangul(parts[1]);

            if (!exestingWords.contains(currentWord)){
                newWords.add(currentWord);
            }
        }
            wordRepository.saveAll(newWords);
    }
}
