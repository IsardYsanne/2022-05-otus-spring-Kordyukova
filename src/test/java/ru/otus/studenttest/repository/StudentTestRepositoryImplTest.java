package ru.otus.studenttest.repository;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentTestRepositoryImplTest {

    @Test
    public void findTest() throws IOException {
        String firstLine = "In what year was the Law of Three Spikelets?;1932;1940";
        PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
        Resource[] resources = scanner.getResources("./test.csv");
        assertNotNull(resources);
        for (Resource res : resources) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(res.getInputStream()));
            String assertLine = bufferedReader.readLine();
            assertEquals(assertLine, firstLine);
        }
    }
}