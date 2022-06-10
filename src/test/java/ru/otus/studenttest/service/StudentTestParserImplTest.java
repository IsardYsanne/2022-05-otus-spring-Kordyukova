package ru.otus.studenttest.service;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StudentTestParserImplTest {

    @Test
    public void parseResourceContent() {
        try {
            PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
            Resource[] resources = scanner.getResources("studentTest.csv");

            StudentTestParserImpl studentTestParser = new StudentTestParserImpl();
            Map<String, String> map = studentTestParser.parseResourceContent(resources);
            String actual = map.toString();
            String expected = "{In what year was the Law of Three Spikelets?=1932, " +
                    "In what year was the Constitution of the Soviet Union adopted?=1924, " +
                    "Who signed the Emancipation reform of 1861?=Alexander II, " +
                    "What year was the Cuban Missile Crisis happened?=1962, " +
                    "What was the name of the confrontation between the Soviet Union and the West?=Cold War}";
            assertEquals(actual, expected);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the resources folder: " + e.getMessage(), e);
        }
    }
}