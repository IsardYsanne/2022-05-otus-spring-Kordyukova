package ru.otus.studenttest.service;

import org.springframework.core.io.Resource;

public interface ResourceScanner {

    Resource[] getResource(String resourceName);
}
