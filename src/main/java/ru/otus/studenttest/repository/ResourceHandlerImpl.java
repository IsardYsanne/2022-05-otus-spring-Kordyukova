package ru.otus.studenttest.repository;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

public class ResourceHandlerImpl implements ResourceHandler {

    @Override
    public Resource[] getResource(String resourceName) {
        try {
            PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
            Resource[] resources = scanner.getResources(resourceName);
            return resources;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the resources folder: " + e.getMessage(), e);
        }
    }
}
