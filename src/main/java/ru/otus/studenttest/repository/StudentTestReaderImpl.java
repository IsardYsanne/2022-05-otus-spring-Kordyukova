package ru.otus.studenttest.repository;

import org.springframework.core.io.Resource;

public class StudentTestReaderImpl implements StudentTestReader {

    private final ResourceHandler resourceHandler;

    private final StudentTestPrinter studentTestPrinter;

    public StudentTestReaderImpl(ResourceHandler resourceHandler, StudentTestPrinter studentTestPrinter) {
        this.resourceHandler = resourceHandler;
        this.studentTestPrinter = studentTestPrinter;
    }

    @Override
    public void readResourceContent(String resourceName) {
        Resource[] resources = resourceHandler.getResource(resourceName);
        if (resources.length == 0) {
            System.out.println("Warning: could not find any resources in this scanned package: " + resourceName);
        } else {
            studentTestPrinter.printResourceContent(resources);
        }
    }
}
