package ru.otus.studenttest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.studenttest.repository.StudentTestRepository;

/**
 * Сервис для "Тестирования".
 */
@Service
public class StudentTestServiceImpl implements StudentTestService {

    /**
     * Репозиторий для "Тестирования"
     */
    private final StudentTestRepository studentTestRepository;

    @Autowired
    public StudentTestServiceImpl(StudentTestRepository studentTestRepository) {
        this.studentTestRepository = studentTestRepository;
    }

    @Override
    public void getTest() {
        studentTestRepository.findTest();
    }
}
