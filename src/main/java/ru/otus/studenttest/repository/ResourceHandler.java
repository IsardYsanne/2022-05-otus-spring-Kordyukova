package ru.otus.studenttest.repository;

import org.springframework.core.io.Resource;

public interface ResourceHandler {

    Resource[] getResource(String resourceName);
}
