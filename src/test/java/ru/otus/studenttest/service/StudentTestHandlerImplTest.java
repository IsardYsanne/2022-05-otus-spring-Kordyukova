package ru.otus.studenttest.service;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

public class StudentTestHandlerImplTest {

    @Test
    public void testHandle() {
        try {
            PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
            Resource[] resources = scanner.getResources("studentTest.csv");
            StudentTestParserImpl studentTestParser = new StudentTestParserImpl();
            Map<String, String> tests = studentTestParser.parseResourceContent(resources);
            assertNotNull(tests);
            Set<String> questions = tests.keySet();
            for (String question : questions) {
                assertNotNull(question);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the resources folder: " + e.getMessage(), e);
        }
    }
}