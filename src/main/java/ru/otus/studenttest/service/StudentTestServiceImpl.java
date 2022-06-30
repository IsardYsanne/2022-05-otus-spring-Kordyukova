package ru.otus.studenttest.service;

import org.springframework.stereotype.Service;

/**
 * Сервис для "Тестирования".
 */
@Service
public class StudentTestServiceImpl implements StudentTestService {

    private final StudentTestResourceReader studentTestResourceReader;

    private final MessageSourceService messageService;

    public StudentTestServiceImpl(StudentTestResourceReader studentTestResourceReader, MessageSourceService messageService) {
        this.studentTestResourceReader = studentTestResourceReader;
        this.messageService = messageService;
    }

    @Override
    public void findTest() {
        studentTestResourceReader.readResourceContent(messageService.getResourceName());
    }
}
