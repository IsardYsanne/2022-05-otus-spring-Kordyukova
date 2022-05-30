package ru.otus.studenttest.repository;

import ru.otus.studenttest.model.entity.StudentTest;

public class StudentTestRepositoryImpl implements StudentTestRepository {

    private final StudentTest studentTest;

    private final StudentTestReader studentTestReader;

    public StudentTestRepositoryImpl(StudentTest studentTest, StudentTestReader studentTestReader) {
        this.studentTest = studentTest;
        this.studentTestReader = studentTestReader;
    }

    @Override
    public void findTest() {
        String resourceName = studentTest.getResourceName();
        studentTestReader.readResourceContent(resourceName);
    }
}
