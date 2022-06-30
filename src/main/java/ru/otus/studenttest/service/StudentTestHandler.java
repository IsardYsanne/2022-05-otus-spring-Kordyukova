package ru.otus.studenttest.service;

import org.springframework.core.io.Resource;

public interface StudentTestHandler {

    void printGreetingWithStudent();

    void testHandle(Resource[] resources);

    String getResponseFromStudent(String question);

    void getResult(int counterGoodAnswers, int studentTestSize);

    void closeReader();
}