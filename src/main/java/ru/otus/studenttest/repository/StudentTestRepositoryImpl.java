package ru.otus.studenttest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.otus.studenttest.model.entity.StudentTest;
import ru.otus.studenttest.service.StudentTestResourceReader;

/**
 * Репозиторий для "Тестирования".
 */
@Repository
public class StudentTestRepositoryImpl implements StudentTestRepository {

    private final StudentTest studentTest;

    private final StudentTestResourceReader studentTestResourceReader;

    @Autowired
    public StudentTestRepositoryImpl(@Value("${resource-path}") StudentTest studentTest, StudentTestResourceReader studentTestResourceReader) {
        this.studentTest = studentTest;
        this.studentTestResourceReader = studentTestResourceReader;
    }

    @Override
    public void findTest() {
        String resourceName = studentTest.getResourceName();
        studentTestResourceReader.readResourceContent(resourceName);
    }
}
