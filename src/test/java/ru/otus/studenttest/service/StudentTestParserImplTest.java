package ru.otus.studenttest.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentTestParserImplTest {

    @Test
    public void parseResourceContent() {
        try {
            PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
            Resource[] resources = scanner.getResources("test-en.csv");

            StudentTestParserImpl studentTestParser = new StudentTestParserImpl();
            Map<String, String> map = studentTestParser.parseResourceContent(resources);
            String actual = map.toString();
            String expected = "{In what year was the Law of Three Spikelets?=1932, " +
                    "In what year was the Constitution of the Soviet Union adopted?=1924, " +
                    "Who signed the Emancipation reform of 1861?=Alexander II, " +
                    "What year was the Cuban Missile Crisis happened?=1962, " +
                    "What was the name of the confrontation between the Soviet Union and the West?=Cold War}";
            assertEquals(actual, expected);
            List<String> answersList = List.of("1932", "1924", "Alexander II", "1962", "Cold War");
            for (int k = 0; k < answersList.size(); k++) {
                List<String> values = new ArrayList<>(map.values());
                assertEquals(answersList.get(k), values.get(k));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the resources folder: " + e.getMessage(), e);
        }
    }
}