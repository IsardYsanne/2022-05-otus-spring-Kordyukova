package ru.otus.studenttest.repository;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentTestPrinterImpl implements StudentTestPrinter {

    @Override
    public void printResourceContent(Resource[] resources) {
        try {
            for (Resource resource : resources) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the resources folder: " + e.getMessage(), e);
        }
    }
}
