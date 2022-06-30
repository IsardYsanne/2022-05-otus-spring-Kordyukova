package ru.otus.studenttest.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Сканер ресурса.
 */
@Component
public class ResourceScannerImpl implements ResourceScanner {

    /**
     * Сканирует ресурс и кладет в массив.
     */
    @Override
    public Resource[] getResource(String resourceName) {
        try {
            PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
            return scanner.getResources(resourceName);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the resources folder: " + e.getMessage(), e);
        }
    }
}
