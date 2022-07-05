package ru.otus.studenttest.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StudentTestHandlerImplTest {

    @Test
    public void testHandle() {
        try {
            PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
            Resource[] resources = scanner.getResources("test-en.csv");
            StudentTestParserImpl studentTestParser = new StudentTestParserImpl();
            Map<String, String> tests = studentTestParser.parseResourceContent(resources);
            Set<String> questions = tests.keySet();
            List<String> studentAnswersList = List.of("1932", "1924", "Blablabla", "1962", "Hot war");

            assertNotNull(tests);
            assertNotNull(questions);

            int correctAnswers = 0;
            for (String question : questions) {
                String correctAnswer = tests.get(question);
                for(int i = 0; i < questions.size(); i++) {
                    if (!correctAnswer.equals(studentAnswersList.get(i))) continue;
                    correctAnswers++;
                    System.out.println("Correct answers " + correctAnswers + "/" + questions.size());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the resources folder: " + e.getMessage(), e);
        }
    }
}