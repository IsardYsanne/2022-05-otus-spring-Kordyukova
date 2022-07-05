package ru.otus.studenttest.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Считывает ресурс и делит его на блоки, которые делятся на один вопрос и ответ.
 */
@Component
public class StudentTestParserImpl implements StudentTestParser {

    /**
     * Считывает блоки с вопросами и ответами. 1 блок - 1 вопрос и ответ к нему.
     * Разделяет каждый блок на вопрос и ответ и заносит в мапу.
     *
     * @param resources массив ресурсов
     * @return ассоциативный массив, состоящий из ключа - вопроса, значения - ответа
     */
    @Override
    public Map<String, String> parseResourceContent(Resource[] resources) {
        Map<String, String> studentTest = new LinkedHashMap<>();
        try {
            for (Resource resource : resources) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
                while (bufferedReader.ready()) {
                    String block = bufferedReader.readLine();
                    String[] itemsOfBlock = block.split(";");
                    for (int i = 0; i < itemsOfBlock.length; i++) {
                        String question = itemsOfBlock[0];
                        String answer = itemsOfBlock[itemsOfBlock.length - 1];
                        studentTest.put(question, answer);
                    }
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the resources folder: " + e.getMessage(), e);
        }
        return studentTest;
    }
}