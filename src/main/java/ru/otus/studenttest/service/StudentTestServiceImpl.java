package ru.otus.studenttest.service;

import ru.otus.studenttest.repository.StudentTestRepository;

public class StudentTestServiceImpl implements StudentTestService {

    private final StudentTestRepository studentTestRepository;

    public StudentTestServiceImpl(StudentTestRepository studentTestRepository) {
        this.studentTestRepository = studentTestRepository;
    }

    @Override
    public void getTest() {
        studentTestRepository.findTest();
    }
}
