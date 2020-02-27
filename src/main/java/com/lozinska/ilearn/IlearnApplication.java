package com.lozinska.ilearn;

import com.lozinska.ilearn.entity.Word;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class IlearnApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(IlearnApplication.class, args);
        FileReader input = new FileReader("C:\\Users\\OlgaPC\\Desktop\\Wocabulary.txt");

        BufferedReader bufRead = new BufferedReader(input);
        String myLine = null;

        while ((myLine = bufRead.readLine()) != null) {
            Word currentWord = new Word();
            String[] parts = myLine.split(" - ");
            currentWord.setTranscription(parts[0]);
            currentWord.setHangul(parts[1]);

            System.out.println(currentWord);
        }
    }

//        try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\OlgaPC\\Desktop\\Wocabulary.txt"))) {
//
//            stream.forEach(System.out::println);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
}



