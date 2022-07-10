package ru.otus.studenttest.service;

import org.springframework.core.io.Resource;
import ru.otus.studenttest.model.entity.StudentTest;

import java.time.LocalDate;
import java.util.List;

public interface StudentTestHandler {

    String getStudentName();

    void testHandle(Resource[] resources);

    String getResponseFromStudent(String question);

    void getResult(int counterGoodAnswers, int studentTestSize, LocalDate date);

    void closeReader();

    List<StudentTest> getResults();
}