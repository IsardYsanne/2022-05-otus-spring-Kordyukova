package ru.otus.studenttest.repository;

import org.springframework.core.io.Resource;

public interface StudentTestPrinter {

    void printResourceContent(Resource[] resources);
}
