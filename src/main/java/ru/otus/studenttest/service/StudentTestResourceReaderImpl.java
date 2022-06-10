package ru.otus.studenttest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Считыватель ресурса.
 */
@Component
public class StudentTestResourceReaderImpl implements StudentTestResourceReader {

    private final ResourceScanner resourceScanner;

    private final StudentTestHandler studentTestHandler;

    @Autowired
    public StudentTestResourceReaderImpl(ResourceScanner resourceScanner, StudentTestHandler studentTestHandler) {
        this.resourceScanner = resourceScanner;
        this.studentTestHandler = studentTestHandler;
    }

    /**
     * Считывает ресурс и выводит ошибку, если ресурс не найден.
     * Если найден, начинает тестировать студента.
     *
     * @param resourceName имя ресурса
     */
    @Override
    public void readResourceContent(String resourceName) {
        Resource[] resources = resourceScanner.getResource(resourceName);
        if (resources.length == 0) {
            System.out.println("Warning: could not find any resources in this scanned package: " + resourceName);
        } else {
            studentTestHandler.testHandle(resources);
        }
    }
}
